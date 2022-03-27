package com.example.internetshop.services.account.impls;

import com.example.internetshop.DTO.account.req.AccountCreate;
import com.example.internetshop.DTO.account.req.AccountUpdate;
import com.example.internetshop.DTO.account.resp.AccountDTO;
import com.example.internetshop.DTO.client.req.ClientModify;
import com.example.internetshop.DTO.user.req.UserModify;
import com.example.internetshop.model.Account;
import com.example.internetshop.model.Client;
import com.example.internetshop.model.User;
import com.example.internetshop.repositories.AccountRepository;
import com.example.internetshop.services.account.services.IAccountService;
import com.example.internetshop.services.client.services.IClientService;
import com.example.internetshop.services.user.services.IUserService;
import com.example.internetshop.settings.ElementExceptionStrings;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService
{
	private final AccountRepository repository;
	private final IUserService userService;
	private final IClientService clientService;

	@Override
	public Page<AccountDTO> getAll(Integer page, Integer size)
	{
		Page<Account> accounts = repository.findAll(PageRequest.of(page, size));

		var accountDTOs = accounts.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<AccountDTO>(accountDTOs);
	}

	@Override
	public AccountDTO get(Integer id) throws Exception
	{
		try
		{
			return convertToDTO(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Account.class, id));
		}
	}

	@Override
	public AccountDTO create(AccountCreate entity) throws Exception
	{
		try
		{
			UserModify newUser = UserModify.builder()
					.password(entity.getPassword())
					.username(entity.getLogin())
					.build();

			ClientModify newClient = ClientModify.builder()
					.phone(entity.getPhone())
					.firstName(entity.getFirstName())
					.middleName(" ")
					.lastName(entity.getLastName())
					.email(entity.getEmail())
					.address(" ")
					.build();

			return convertToDTO(
					repository.save(Account.builder()
							.balance(entity.getBalance())
							.user(User.builder()
									.id(userService.create(newUser).getId())
									.build())
							.client(Client.builder()
									.id(clientService.create(newClient).getId())
									.build())
							.isActive(entity.isActive())
							.build())
			);

		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getCreateExceptionString(entity));
		}
	}

	@Override
	public AccountDTO update(AccountUpdate entity) throws Exception
	{
		try
		{
			Account account = repository.getById(entity.getId());

			return convertToDTO(repository.save(
					Account.builder()
							.isActive(entity.isActive())
							.id(account.getId())
							.balance(entity.getBalance())
							.client(Client.builder()
									.id(account.getClient().getId())
									.build())
							.user(User.builder()
									.id(account.getUser().getId())
									.build())
							.build()
			));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getUpdateExceptionString(entity));
		}
	}

	@Override
	public void delete(Integer id) throws Exception
	{
		try
		{
			Account account = repository.getById(id);

			Integer userId = account.getUser().getId();
			Integer clientId = account.getClient().getId();

			repository.delete(account);

			userService.delete(userId);
			clientService.delete(clientId);
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Account.class, id));
		}
	}

	@Override
	public Client findClientByUserId(Integer id)
	{
		Account account = repository.findByUserId(id);

		return account == null ? null : account.getClient();
	}

	@Override
	public User findUserByClientId(Integer id)
	{
		Account account = repository.findByClientId(id);

		return account == null ? null : account.getUser();
	}

	@Override
	public String convertToDTOString(Integer accountId)
	{
		try
		{
			Account account = repository.getById(accountId);

			return convertToDTO(account).toString();
		}
		catch (Exception e)
		{
			return "-DELETED ACCOUNT-";
		}
	}

	private AccountDTO convertToDTO(Account entity)
	{
		return AccountDTO.builder()
				.id(entity.getId())
				.clientId(entity.getClient().getId())
				.userId(entity.getUser().getId())
				.balance(entity.getBalance())
				.isActive(entity.isActive())
				.build();
	}

}