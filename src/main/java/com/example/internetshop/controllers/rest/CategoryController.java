package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.category.resp.CategoryDTO;
import com.example.internetshop.services.category.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(categoryService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody CategoryDTO entity) {
        entity.setId(id);
        return ResponseEntity.ok(categoryService.update(entity));
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO entity) {
        return ResponseEntity.ok(categoryService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}