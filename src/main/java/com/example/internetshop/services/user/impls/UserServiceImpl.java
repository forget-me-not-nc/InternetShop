package com.example.internetshop.services.user.impls;

import com.example.internetshop.model.User;
import com.example.internetshop.repositories.UserRepository;
import com.example.internetshop.services.user.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.UserServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:02
 * @Version UserServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService
{

	private final UserRepository repository;

	@Override
	public Page<User> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public User get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public User update(User user)
	{
		return repository.save(user);
	}

	@Override
	public User create(User user)
	{
		return repository.save(user);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
