package com.example.internetshop.services.client.impls;

import com.example.internetshop.DTO.client.req.ClientModify;
import com.example.internetshop.DTO.client.resp.ClientDTO;
import com.example.internetshop.model.Client;
import com.example.internetshop.repositories.ClientRepository;
import com.example.internetshop.services.client.services.IClientService;
import com.example.internetshop.settings.ElementExceptionStrings;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:00
 * @Version ClientServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService
{
	private final ClientRepository repository;

	@Override
	public Page<ClientDTO> getAll(Integer page, Integer size)
	{
		Page<Client> clients = repository.findAll(PageRequest.of(page, size));

		var clientsDTOs = clients.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<ClientDTO>(clientsDTOs);
	}

	@Override
	public ClientDTO get(Integer id) throws Exception
	{
		try
		{
			return convertToDTO(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Client.class, id));
		}
	}

	@Override
	public ClientDTO create(ClientModify entity) throws Exception
	{

		try
		{
			return convertToDTO(repository.save(Client.builder()
					.address(entity.getAddress())
					.firstName(entity.getFirstName())
					.lastName(entity.getLastName())
					.middleName(entity.getMiddleName())
					.phone(entity.getPhone())
					.email(entity.getEmail())
					.build())
			);
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getCreateExceptionString(entity));
		}
	}

	@Override
	public ClientDTO update(ClientModify entity) throws Exception
	{
		try
		{
			Client client = repository.getById(entity.getId());

			return convertToDTO(repository.save(Client.builder()
					.id(client.getId())
					.address(entity.getAddress())
					.firstName(entity.getFirstName())
					.lastName(entity.getLastName())
					.middleName(entity.getMiddleName())
					.phone(entity.getPhone())
					.email(entity.getEmail())
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
			throw new Exception(ElementExceptionStrings.getExceptionString(Client.class, id));
		}
	}

	private ClientDTO convertToDTO(Client entity)
	{
		return ClientDTO.builder()
				.id(entity.getId())
				.address(entity.getAddress())
				.email(entity.getEmail())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.middleName(entity.getMiddleName())
				.phone(entity.getPhone())
				.build();
	}

}