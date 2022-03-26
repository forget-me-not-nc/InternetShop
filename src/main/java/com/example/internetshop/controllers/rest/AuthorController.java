package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.author.AuthorDTO;
import com.example.internetshop.services.author.impls.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:48
 * @Version AuthorController: 1.0
 */

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController
{
	private final AuthorServiceImpl authorService;

	@GetMapping("/getAll")
	public ResponseEntity<List<AuthorDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(authorService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AuthorDTO> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(authorService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<AuthorDTO> update(@RequestBody AuthorDTO entity)
	{
		return ResponseEntity.ok(authorService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO entity)
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