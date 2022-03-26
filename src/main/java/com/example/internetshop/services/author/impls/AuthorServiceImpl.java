package com.example.internetshop.services.author.impls;

import com.example.internetshop.DTO.author.AuthorDTO;
import com.example.internetshop.repositories.AuthorRepository;
import com.example.internetshop.services.author.services.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:57
 * @Version AuthorServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService
{

	private final AuthorRepository repository;


	@Override
	public Page<AuthorDTO> getAll(Integer page, Integer size)
	{
		return null;
	}

	@Override
	public AuthorDTO get(Integer id)
	{
		return null;
	}

	@Override
	public AuthorDTO update(AuthorDTO authorDTO)
	{
		return null;
	}

	@Override
	public AuthorDTO create(AuthorDTO authorDTO)
	{
		return null;
	}

	@Override
	public void delete(Integer id)
	{

	}
}