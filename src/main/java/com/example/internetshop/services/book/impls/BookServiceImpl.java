package com.example.internetshop.services.book.impls;

import com.example.internetshop.DTO.book.BookDTO;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.book.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
	public Page<BookDTO> getAll(Integer page, Integer size)
	{
		return null;
	}

	@Override
	public BookDTO get(Integer id)
	{
		return null;
	}

	@Override
	public BookDTO update(BookDTO bookDTO)
	{
		return null;
	}

	@Override
	public BookDTO create(BookDTO bookDTO)
	{
		return null;
	}

	@Override
	public void delete(Integer id)
	{

	}
}