package com.example.internetshop.services.account.impls;

import com.example.internetshop.model.Account;
import com.example.internetshop.repositories.AccountRepository;
import com.example.internetshop.services.account.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

	@Override
	public Page<Account> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Account get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public Account update(Account account)
	{
		return repository.save(account);
	}

	@Override
	public Account create(Account account)
	{
		return repository.save(account);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
