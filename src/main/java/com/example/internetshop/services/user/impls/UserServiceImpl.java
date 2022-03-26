package com.example.internetshop.services.user.impls;

import com.example.internetshop.DTO.account.AccountDTO;
import com.example.internetshop.DTO.client.ClientDTO;
import com.example.internetshop.DTO.user.SimplifiedUser;
import com.example.internetshop.DTO.user.UserDTO;
import com.example.internetshop.model.User;
import com.example.internetshop.repositories.UserRepository;
import com.example.internetshop.services.account.services.IAccountService;
import com.example.internetshop.services.client.services.IClientService;
import com.example.internetshop.services.user.services.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
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
public class UserServiceImpl implements IUserService
{
	private UserRepository repository;
	private IClientService clientService;
	private IAccountService accountService;

	@Autowired
	public void setRepository(UserRepository repository)
	{
		this.repository = repository;
	}

	@Autowired
	public void setClientService(IClientService clientService)
	{
		this.clientService = clientService;
	}

	@Autowired
	public void setAccountService(IAccountService accountService)
	{
		this.accountService = accountService;
	}

	@Override
	public Page<UserDTO> getAll(Integer page, Integer size)
	{
		Page<User> users = repository.findAll(PageRequest.of(page, size));

		var usersDTOs = users.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<UserDTO>(usersDTOs);
	}

	@Override
	public UserDTO get(Integer id)
	{
		return convertToDTO(repository.getById(id));
	}

	@Override
	public UserDTO update(UserDTO userDTO)
	{
		return convertToDTO(repository.save(DTO_ToEntity(userDTO)));
	}

	@Override
	public UserDTO create(UserDTO userDTO)
	{
		userDTO.setId(null);

		User newUser = repository.save(DTO_ToEntity(userDTO));

		accountService.create(
				AccountDTO.builder()
						.balance(BigDecimal.ZERO)
						.isActive(false)
						.userId(newUser.getId())
						.clientId(
								clientService.create(
										ClientDTO.builder()
												.phone("")
												.middleName("")
												.lastName(userDTO.getLastName())
												.firstName(userDTO.getFirstName())
												.email("")
												.address("")
												.build()
								).getId()
						)
						.build()
		);

		return convertToDTO(newUser);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(repository.getById(id));
	}

	@Override
	public User getUser(Integer id)
	{
		return repository.getById(id);
	}

	@Override
	public SimplifiedUser simplifieUser(UserDTO user)
	{
		return SimplifiedUser.builder()
				.id(user.getId())
				.login(user.getLogin())
				.build();
	}

	private UserDTO convertToDTO(User user)
	{
		return UserDTO.builder()
				.id(user.getId())
				.login(user.getLogin())
				.password(user.getPassword())
				.build();
	}

	private User DTO_ToEntity(UserDTO dto)
	{
		return User.builder()
				.id(dto.getId())
				.login(dto.getLogin())
				.password(dto.getPassword())
				.build();
	}
}