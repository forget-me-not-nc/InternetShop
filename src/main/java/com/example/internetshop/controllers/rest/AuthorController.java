package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.author.req.AuthorModify;
import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.services.author.services.IAuthorService;
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
public class AuthorController {
    private final IAuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<AuthorDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(authorService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Integer id, @RequestBody AuthorModify entity) {
        entity.setId(id);
        return ResponseEntity.ok(authorService.update(entity));
    }

    @PutMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorModify entity) {
        return ResponseEntity.ok(authorService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        authorService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}