package com.example.internetshop.services.account.impls;

import com.example.internetshop.DTO.account.AccountDTO;
import com.example.internetshop.model.Account;
import com.example.internetshop.repositories.AccountRepository;
import com.example.internetshop.services.account.services.IAccountService;
import com.example.internetshop.services.client.services.IClientService;
import com.example.internetshop.services.user.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:54
 * @Version AccountServiceImpl: 1.0
 */

@Service
public class AccountServiceImpl implements IAccountService
{
	private AccountRepository repository;
	private IClientService clientService;
	private IUserService userService;

	@Autowired
	public void setRepository(AccountRepository repository)
	{
		this.repository = repository;
	}

	@Autowired
	public void setClientService(IClientService clientService)
	{
		this.clientService = clientService;
	}


	@Autowired
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	@Override
	public Page<AccountDTO> getAll(Integer page, Integer size)
	{
		Page<Account> accounts = repository.findAll(PageRequest.of(page, size));

		var accountDTOs = accounts.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<AccountDTO>(accountDTOs);
	}

	@Override
	public AccountDTO get(Integer id)
	{
		return convertToDTO(repository.getById(id));
	}

	@Override
	public AccountDTO update(AccountDTO accountDTO)
	{
		var account = repository.getById(accountDTO.getId());

		account.setBalance(accountDTO.getBalance());
		account.setActive(accountDTO.isActive());

		return convertToDTO(account);
	}

	@Override
	public AccountDTO create(AccountDTO accountDTO)
	{
		var account = repository.save(Account.builder()
				.user(userService.getUser(accountDTO.getUserId()))
				.client(clientService.getClient(accountDTO.getClientId()))
				.isActive(accountDTO.isActive())
				.balance(accountDTO.getBalance())
				.build());

		return convertToDTO(account);
	}

	@Override
	public void delete(Integer id)
	{
		Account account = repository.getById(id);

		userService.delete(account.getUser().getId());
		clientService.delete(account.getClient().getId());
		repository.delete(account);
	}

	private AccountDTO convertToDTO(Account account)
	{
		return AccountDTO.builder()
				.id(account.getId())
				.clientId(account.getClient().getId())
				.userId(account.getUser().getId())
				.isActive(account.isActive())
				.balance(account.getBalance())
				.build();
	}
}