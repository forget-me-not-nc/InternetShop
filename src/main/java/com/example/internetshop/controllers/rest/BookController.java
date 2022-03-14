package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.Book;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.book.impls.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 19.02.2022|12:52
 * @Version BookController: 1.0
 */

@RestController("/books")
@RequiredArgsConstructor
public class BookController
{
	private final BookServiceImpl bookService;

	@GetMapping("/getAll")
	public ResponseEntity<Page<Book>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(bookService.getAll(page, size));
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Book> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(bookService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Book> update(@RequestParam Book entity)
	{
		return ResponseEntity.ok(bookService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<Book> create(@RequestParam Book entity)
	{
		return ResponseEntity.ok(bookService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		bookService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}