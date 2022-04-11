package com.example.internetshop.services.author;

import com.example.internetshop.model.Author;
import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.AuthorRepository;
import com.example.internetshop.services.author.impls.AuthorServiceImpl;
import com.example.internetshop.services.category.impls.CategoryServiceImpl;
import com.example.internetshop.stubs.AccountStub;
import com.example.internetshop.stubs.AuthorStub;
import com.example.internetshop.stubs.CategoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    private AuthorServiceImpl service;

    @Mock
    private AuthorRepository repository;

    @BeforeEach
    void setup()
    {
        service = new AuthorServiceImpl(repository);
    }

    @Test
    void successfulGetAll() {
        var expect = AuthorStub.generateAuthorsList();

        when(repository.findAll(PageRequest.of(CategoryStub.page, CategoryStub.size)))
                .thenReturn(new PageImpl<Author>(expect));

        var result = service.getAll(0,2);

        assertAll(() ->{
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getFirstName(), expect.get(0).getFirstName());
            assertEquals(res1.getLastName(), expect.get(0).getLastName());
            assertEquals(res1.getMiddleName(), expect.get(0).getMiddleName());

            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getFirstName(), expect.get(1).getFirstName());
            assertEquals(res2.getLastName(), expect.get(1).getLastName());
            assertEquals(res2.getMiddleName(), expect.get(1).getMiddleName());
        });
    }

    @Test
    void successfulGet() {
        var expect = AuthorStub.generateAuthor();

        when(repository.getById(AuthorStub.ID)).thenReturn(expect);

        var result = service.get(AuthorStub.ID);

        assertAll(() ->{
            assertEquals(expect.getId(), result.getId());
            assertEquals(expect.getFirstName(), result.getFirstName());
            assertEquals(expect.getLastName(), result.getLastName());
            assertEquals(expect.getMiddleName(), result.getMiddleName());
        });
    }

    @Test
    void successfulCreate() {
        var expect = AuthorStub.generateAuthor();

        when(repository.save(any())).thenReturn(expect);

        var result = service.create(AuthorStub.generateAuthorModifyRequest());

        assertAll(() ->{
            assertEquals(result.getId(), expect.getId());
            assertEquals(expect.getFirstName(), result.getFirstName());
            assertEquals(expect.getLastName(), result.getLastName());
            assertEquals(expect.getMiddleName(), result.getMiddleName());
        });
    }

    @Test
    void successfulUpdate() {
        var expect = AuthorStub.generateAuthor();

        when(repository.save(any())).thenReturn(expect);

        var result = service.update(AuthorStub.generateAuthorModifyRequest());

        assertAll(() ->{
            assertEquals(result.getId(), expect.getId());
            assertEquals(expect.getFirstName(), result.getFirstName());
            assertEquals(expect.getLastName(), result.getLastName());
            assertEquals(expect.getMiddleName(), result.getMiddleName());
        });
    }

    @Test
    void successfulDelete() {
        var deleteCaptor = ArgumentCaptor.forClass(Integer.class);

        service.delete(AuthorStub.ID);
        verify(repository, atLeast(1)).deleteById(deleteCaptor.capture());
        assertEquals(AuthorStub.ID, deleteCaptor.getValue());
    }

    @Test
    void successfulConvertToDTO() {
        var expect = AuthorStub.generateDTO();
        var getExpect = AuthorStub.generateAuthor();

        when(repository.getById(AuthorStub.ID)).thenReturn(getExpect);

        var result = service.convertToDTO(AuthorStub.ID);

        assertAll(() ->{
            assertEquals(result.getId(), expect.getId());
            assertEquals(expect.getFirstName(), result.getFirstName());
            assertEquals(expect.getLastName(), result.getLastName());
            assertEquals(expect.getMiddleName(), result.getMiddleName());
        });
    }
}