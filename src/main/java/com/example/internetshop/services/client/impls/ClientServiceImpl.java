package com.example.internetshop.services.client.impls;

import com.example.internetshop.DTO.client.ClientDTO;
import com.example.internetshop.model.Client;
import com.example.internetshop.repositories.ClientRepository;
import com.example.internetshop.services.client.services.IClientService;
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

		var clientDTOs = clients.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<ClientDTO>(clientDTOs);
	}

	@Override
	public ClientDTO get(Integer id)
	{
		return convertToDTO(repository.getById(id));
	}

	@Override
	public ClientDTO update(ClientDTO clientDTO)
	{
		return convertToDTO(repository.save(DTO_ToEntity(clientDTO)));
	}

	@Override
	public ClientDTO create(ClientDTO clientDTO)
	{
		clientDTO.setId(null);
		return convertToDTO(repository.save(DTO_ToEntity(clientDTO)));
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(repository.getById(id));
	}

	@Override
	public Client getClient(Integer id)
	{
		return repository.getById(id);
	}

	private ClientDTO convertToDTO(Client client)
	{
		return ClientDTO.builder()
				.id(client.getId())
				.address(client.getAddress())
				.email(client.getEmail())
				.firstName(client.getFirstName())
				.lastName(client.getLastName())
				.middleName(client.getMiddleName())
				.phone(client.getPhone())
				.build();
	}

	private Client DTO_ToEntity(ClientDTO dto)
	{
		return Client.builder()
				.id(dto.getId())
				.address(dto.getAddress())
				.email(dto.getEmail())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.middleName(dto.getMiddleName())
				.phone(dto.getPhone())
				.build();
	}
}