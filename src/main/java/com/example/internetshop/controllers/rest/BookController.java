package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.book.req.BookModify;
import com.example.internetshop.DTO.book.resp.BookDTO;
import com.example.internetshop.services.book.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class BookController {
    private final IBookService bookService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<BookDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(bookService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<BookDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDTO> update(@PathVariable Integer id, @RequestBody BookModify entity) {
        entity.setId(id);
        return ResponseEntity.ok(bookService.update(entity));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDTO> create(@RequestBody BookModify entity) {
        return ResponseEntity.ok(bookService.create(entity));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}/categories")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<String>> getBookCategories(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getCategoriesNamesByBookId(id));
    }
}