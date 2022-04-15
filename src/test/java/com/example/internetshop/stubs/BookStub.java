package com.example.internetshop.stubs;

import com.example.internetshop.DTO.book.req.BookModify;
import com.example.internetshop.DTO.book.resp.BookDTO;
import com.example.internetshop.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookStub
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 09.04.2022|20:00
 * @Version BookStub: 1.0
 */

public final class BookStub {

    public static final Integer ID = 1;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Book generateBook() {
        return Book.builder()
                .id(ID)
                .name("Name")
                .price(BigDecimal.TEN)
                .publishingHouse("PH")
                .categories(CategoryStub.generateCategoriesList())
                .authors(AuthorStub.generateAuthorsList())
                .build();
    }

    public static BookDTO generateBookDTO() {
        return BookDTO.builder()
                .id(ID)
                .categories(new ArrayList<>(Arrays.asList(
                        CategoryStub.generateDTO(),
                        CategoryStub.generateDTO_2()
                )))
                .authors(new ArrayList<>(Arrays.asList(
                        AuthorStub.generateDTO(),
                        AuthorStub.generateDTO_2()
                )))
                .name("Name")
                .price(BigDecimal.TEN)
                .build();
    }

    public static List<Book> generateBooksList() {
        return new ArrayList<>(
                Arrays.asList(
                        Book.builder()
                                .id(ID)
                                .name("Name")
                                .price(BigDecimal.TEN)
                                .publishingHouse("PH")
                                .categories(new ArrayList<>())
                                .authors(new ArrayList<>())
                                .build(),
                        Book.builder()
                                .id(ID + 1)
                                .name("Name")
                                .price(BigDecimal.TEN)
                                .publishingHouse("PH")
                                .categories(new ArrayList<>())
                                .authors(new ArrayList<>())
                                .build()
                )
        );
    }

    public static BookModify generateBookModifyRequest() {
        return BookModify.builder()
                .id(ID)
                .authors(new ArrayList<>())
                .categories(new ArrayList<>())
                .name("Name")
                .price(BigDecimal.TEN)
                .publishingHouse("PH")
                .build();
    }
}