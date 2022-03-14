package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.Author;
import com.example.internetshop.services.author.impls.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:48
 * @Version AuthorController: 1.0
 */

@RestController("/authors")
@RequiredArgsConstructor
public class AuthorController
{
	private final AuthorServiceImpl authorService;

	@GetMapping("/getAll")
	public ResponseEntity<Page<Author>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(authorService.getAll(page, size));
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Author> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(authorService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Author> update(@RequestParam Author entity)
	{
		return ResponseEntity.ok(authorService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<Author> create(@RequestParam Author entity)
	{
		return ResponseEntity.ok(authorService.create(entity));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		authorService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}