package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.Category;
import com.example.internetshop.services.category.impls.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:48
 * @Version CategoryController: 1.0
 */

@RestController("/categories")
@RequiredArgsConstructor
public class CategoryController
{
	private final CategoryServiceImpl categoryService;

	@GetMapping("/getAll")
	public ResponseEntity<Page<Category>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(categoryService.getAll(page, size));
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Category> get(@PathVariable Integer id)
	{
		return  ResponseEntity.ok(categoryService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Category> update(@RequestParam Category entity)
	{
		return  ResponseEntity.ok(categoryService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<Category> create(@RequestParam Category entity)
	{
		return ResponseEntity.ok(categoryService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		categoryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}