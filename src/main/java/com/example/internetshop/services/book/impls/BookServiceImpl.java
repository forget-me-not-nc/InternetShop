package com.example.internetshop.services.book.impls;

import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.book.services.IBookService;
import lombok.RequiredArgsConstructor;
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

}