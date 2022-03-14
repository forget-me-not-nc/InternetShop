package com.example.internetshop.services.book.impls;

import com.example.internetshop.model.Book;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.book.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:58
 * @Version BookServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService
{

	private final BookRepository repository;

	@Override
	public Page<Book> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Book get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public Book update(Book book)
	{
		return repository.save(book);
	}

	@Override
	public Book create(Book book)
	{
		return repository.save(book);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
