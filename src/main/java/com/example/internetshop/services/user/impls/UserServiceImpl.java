package com.example.internetshop.services.user.impls;

import com.example.internetshop.DTO.client.resp.ClientDTO;
import com.example.internetshop.DTO.user.req.UserModify;
import com.example.internetshop.DTO.user.resp.UserDTO;
import com.example.internetshop.model.Client;
import com.example.internetshop.model.User;
import com.example.internetshop.repositories.UserRepository;
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
	public Page<UserDTO> getAll(Integer page, Integer size)
	{
		Page<User> users = repository.findAll(PageRequest.of(page, size));

		var usersDTOs = users.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<UserDTO>(usersDTOs);
	}

	@Override
	public UserDTO get(Integer id) throws Exception
	{
		try
		{
			return convertToDTO(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(User.class, id));
		}
	}

	@Override
	public UserDTO create(UserModify entity) throws Exception
	{
		try
		{
			return convertToDTO(repository.save(User.builder()
					.login(entity.getUsername())
					.password(entity.getPassword())
					.build())
			);
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getCreateExceptionString(entity));
		}
	}

	@Override
	public UserDTO update(UserModify entity) throws Exception
	{
		try
		{
			User user = repository.getById(entity.getId());

			return convertToDTO(repository.save(User.builder()
					.id(user.getId())
					.login(entity.getUsername())
					.password(entity.getPassword())
					.build())
			);
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
			repository.delete(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(User.class, id));
		}
	}

	private UserDTO convertToDTO(User entity)
	{
		return UserDTO.builder()
				.id(entity.getId())
				.username(entity.getLogin())
				.build();
	}
}