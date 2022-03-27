package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.book.req.BookModify;
import com.example.internetshop.DTO.book.resp.BookDTO;
import com.example.internetshop.services.book.impls.BookServiceImpl;
import com.example.internetshop.services.book.services.IBookService;
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
	private final IBookService bookService;

	@GetMapping
	public ResponseEntity<List<BookDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(bookService.getAll(page, size).getContent());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> get(@PathVariable Integer id) throws Exception
	{
		return ResponseEntity.ok(bookService.get(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable Integer id, @RequestBody BookModify entity) throws Exception
	{
		entity.setId(id);
		return ResponseEntity.ok(bookService.update(entity));
	}

	@PutMapping
	public ResponseEntity<BookDTO> create(@RequestBody BookModify entity) throws Exception
	{
		return ResponseEntity.ok(bookService.create(entity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception
	{
		bookService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}