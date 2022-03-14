package com.example.internetshop.services.author.impls;

import com.example.internetshop.model.Author;
import com.example.internetshop.repositories.AuthorRepository;
import com.example.internetshop.services.author.services.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Author> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Author get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public Author update(Author author)
	{
		return repository.save(author);
	}

	@Override
	public Author create(Author author)
	{
		return repository.save(author);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
