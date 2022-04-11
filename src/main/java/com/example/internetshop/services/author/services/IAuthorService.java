package com.example.internetshop.services.author.services;

import com.example.internetshop.DTO.author.req.AuthorModify;
import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.model.Author;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IAuthorService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:57
 * @Version IAuthorService: 1.0
 */

public interface IAuthorService {
    Page<AuthorDTO> getAll(Integer page, Integer size);

    AuthorDTO get(Integer id);

    AuthorDTO create(AuthorModify entity);

    AuthorDTO update(AuthorModify entity);

    void delete(Integer id);

    AuthorDTO convertToDTO(Author entity);

    AuthorDTO convertToDTO(Integer authorId);
}