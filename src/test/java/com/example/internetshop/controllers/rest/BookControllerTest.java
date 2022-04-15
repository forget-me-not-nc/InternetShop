package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.Book;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.author.services.IAuthorService;
import com.example.internetshop.services.category.services.ICategoryService;
import com.example.internetshop.stubs.BookStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static com.example.internetshop.configuration.ServletRequestConfig.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository repository;

    @MockBean
    private IAuthorService authorService;

    @MockBean
    private ICategoryService categoryService;

    @Test
    @WithMockUser(roles = {"ADMIN", "USER"})
    void getAll() throws Exception {
        var request = BookStub.generateBooksList();

        when(repository.findAll(PageRequest.of(BookStub.page, BookStub.size)))
                .thenReturn(new PageImpl<Book>(request));

        mockMvc.perform(getRequest("/books?page=0&size=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[*].price", containsInAnyOrder(10, 10)))
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("Name", "Name")))
                .andExpect(jsonPath("$[*].authors[*]", hasSize(0)))
                .andExpect(jsonPath("$[*].categories[*]", hasSize(0)));
    }

    @Test
    @WithMockUser(roles = {"ADMIN", "USER"})
    void get() throws Exception {
        var request = BookStub.generateBook();

        when(repository.getById(anyInt())).thenReturn(request);

        mockMvc.perform(getRequest("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(request.getPrice().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(request.getName())));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception {
        var request = BookStub.generateBookModifyRequest();
        request.setName("New name");

        var expect = BookStub.generateBook();
        expect.setName("New name");

        when(repository.save(any())).thenReturn(expect);

        mockMvc.perform(putRequest("/books/1", request))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getPrice().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getName())))
                .andExpect(jsonPath("$[*].authors[*]", empty()))
                .andExpect(jsonPath("$[*].categories[*]", empty()));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void create() throws Exception {
        var request = BookStub.generateBookModifyRequest();

        var expect = BookStub.generateBook();

        when(repository.save(any())).thenReturn(expect);

        mockMvc.perform(postRequest("/books", request))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getPrice().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getName())))
                .andExpect(jsonPath("$[*].authors[*]", empty()))
                .andExpect(jsonPath("$[*].categories[*]", empty()));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(deleteRequest("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(repository, atLeast(1)).deleteById(1);
    }

    @Test
    @WithMockUser(roles = {"ADMIN", "USER"})
    void getBookCategories() throws Exception {
        when(categoryService.getCategoriesNamesByBookId(anyInt())).thenReturn(new ArrayList<String>());

        mockMvc.perform(getRequest("/books/1/categories"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[*]", empty()));
    }

}