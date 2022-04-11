package com.example.internetshop.services.book.services;

import com.example.internetshop.DTO.book.req.BookModify;
import com.example.internetshop.DTO.book.resp.BookDTO;
import com.example.internetshop.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IBookService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:58
 * @Version IBookService: 1.0
 */

public interface IBookService {
    Page<BookDTO> getAll(Integer page, Integer size);

    BookDTO get(Integer id);

    BookDTO create(BookModify entity);

    BookDTO update(BookModify entity);

    void delete(Integer id);

    BookDTO convertToDTO(Book entity);

    String convertToDTOString(Integer bookId);

    List<String> getCategoriesNamesByBookId(Integer bookId);
}