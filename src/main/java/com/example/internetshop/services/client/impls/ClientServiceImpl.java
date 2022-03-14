package com.example.internetshop.services.client.impls;

import com.example.internetshop.model.Client;
import com.example.internetshop.repositories.ClientRepository;
import com.example.internetshop.services.client.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
	public Page<Client> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Client get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public Client update(Client client)
	{
		return repository.save(client);
	}

	@Override
	public Client create(Client client)
	{
		return repository.save(client);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
