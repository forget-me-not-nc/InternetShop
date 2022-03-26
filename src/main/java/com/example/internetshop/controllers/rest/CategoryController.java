package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.category.CategoryDTO;
import com.example.internetshop.services.category.impls.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:48
 * @Version CategoryController: 1.0
 */

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController
{
	private final CategoryServiceImpl categoryService;

	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(categoryService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CategoryDTO> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(categoryService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO entity)
	{
		return ResponseEntity.ok(categoryService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO entity)
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