package com.example.internetshop.services.book;

import com.example.internetshop.model.Account;
import com.example.internetshop.model.Author;
import com.example.internetshop.model.Book;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.author.impls.AuthorServiceImpl;
import com.example.internetshop.services.book.impls.BookServiceImpl;
import com.example.internetshop.services.category.impls.CategoryServiceImpl;
import com.example.internetshop.stubs.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    private BookServiceImpl service;

    @Mock
    private BookRepository repository;

    @Mock
    private CategoryServiceImpl categoryService;

    @Mock
    private AuthorServiceImpl authorService;

    @BeforeEach
    void setup() {
        service = new BookServiceImpl(repository, authorService, categoryService);
    }

    @Test
    void successfulGetAll() {
        var expect = BookStub.generateBooksList();

        when(repository.findAll(PageRequest.of(BookStub.page, BookStub.size)))
                .thenReturn(new PageImpl<Book>(expect));

        var result = service.getAll(BookStub.page, BookStub.size);

        assertAll(() ->{
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getAuthors().size(), expect.get(0).getAuthors().size());
            assertEquals(res1.getCategories().size(), expect.get(0).getCategories().size());
            assertEquals(res1.getName(), expect.get(0).getName());
            assertEquals(res1.getPrice(), expect.get(0).getPrice());

            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getAuthors().size(), expect.get(1).getAuthors().size());
            assertEquals(res2.getCategories().size(), expect.get(1).getCategories().size());
            assertEquals(res2.getName(), expect.get(1).getName());
            assertEquals(res2.getPrice(), expect.get(1).getPrice());
        });
    }

    @Test
    void successfulGet() {
        var expect = BookStub.generateBook();

        when(repository.getById(BookStub.ID)).thenReturn(expect);

        var result = service.get(BookStub.ID);

        assertAll(() ->{
            assertEquals(expect.getId(), result.getId());
            assertEquals(expect.getAuthors().size(), result.getAuthors().size());
            assertEquals(expect.getCategories().size(), result.getCategories().size());
            assertEquals(expect.getName(), result.getName());
            assertEquals(expect.getPrice(), result.getPrice());
        });
    }

    @Test
    void successfulCreate() {
        var expect = BookStub.generateBook();

        when(repository.save(any())).thenReturn(expect);

        var result = service.create(BookStub.generateBookModifyRequest());

        assertAll(() ->{
            assertEquals(expect.getId(), result.getId());
            assertEquals(expect.getAuthors().size(), result.getAuthors().size());
            assertEquals(expect.getCategories().size(), result.getCategories().size());
            assertEquals(expect.getName(), result.getName());
            assertEquals(expect.getPrice(), result.getPrice());
        });
    }

    @Test
    void successfulUpdate() {
        var expect = BookStub.generateBook();

        when(repository.save(any())).thenReturn(expect);

        var result = service.update(BookStub.generateBookModifyRequest());

        assertAll(() ->{
            assertEquals(expect.getId(), result.getId());
            assertEquals(expect.getAuthors().size(), result.getAuthors().size());
            assertEquals(expect.getCategories().size(), result.getCategories().size());
            assertEquals(expect.getName(), result.getName());
            assertEquals(expect.getPrice(), result.getPrice());
        });
    }

    @Test
    void successfulDelete() {
        var deleteCaptor = ArgumentCaptor.forClass(Integer.class);

        service.delete(BookStub.ID);
        verify(repository, atLeast(1)).deleteById(deleteCaptor.capture());
        assertEquals(BookStub.ID, deleteCaptor.getValue());
    }

    @Test
    void successfulConvertToDTO() {
        var expect = BookStub.generateBookDTO();
        var getExpect = BookStub.generateBook();

        var result = service.convertToDTO(getExpect);

        assertAll(() ->{
            assertEquals(expect.getId(), result.getId());
            assertEquals(expect.getAuthors().size(), result.getAuthors().size());
            assertEquals(expect.getCategories().size(), result.getCategories().size());
            assertEquals(expect.getName(), result.getName());
            assertEquals(expect.getPrice(), result.getPrice());
        });
    }

    @Test
    void successfulConvertToDTOString() {
    }

    @Test
    void successfulGetBookAuthorDTOs() {
    }

    @Test
    void successfulGetBookCategoryDTOs() {
    }

    @Test
    void successfulBindBookWithAuthors() {
    }

    @Test
    void successfulBindBookWithCategories() {
    }
}