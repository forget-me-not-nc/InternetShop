package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.book.BookDTO;
import com.example.internetshop.services.book.impls.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 19.02.2022|12:52
 * @Version BookController: 1.0
 */

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController
{
	private final BookServiceImpl bookService;

	@GetMapping("/getAll")
	public ResponseEntity<List<BookDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(bookService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BookDTO> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(bookService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<BookDTO> update(@RequestBody BookDTO entity)
	{
		return ResponseEntity.ok(bookService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<BookDTO> create(@RequestBody BookDTO entity)
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