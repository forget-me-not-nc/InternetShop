package com.example.internetshop.controllers.rest;

import com.example.internetshop.repositories.OrderRepository;
import com.example.internetshop.services.account.services.IAccountService;
import com.example.internetshop.services.book.services.IBookService;
import com.example.internetshop.stubs.AccountStub;
import com.example.internetshop.stubs.BookStub;
import com.example.internetshop.stubs.OrderStub;
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

import static com.example.internetshop.configuration.ServletRequestConfig.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository repository;

    @MockBean
    private IAccountService accountService;

    @MockBean
    private IBookService bookService;

    @Test
    @WithMockUser(roles = {"ADMIN", "USER"})
    void getAll() throws Exception {
        var request = OrderStub.generateOrdersList();

        when(repository.findAll(PageRequest.of(OrderStub.page, OrderStub.size)))
                .thenReturn(new PageImpl<>(request));

        when(accountService.convertToDTOString(anyInt())).thenReturn(AccountStub.generateAccountDTO().toString());
        when(bookService.convertToDTOString(anyInt())).thenReturn(BookStub.generateBookDTO().toString());

        mockMvc.perform(getRequest("/orders?page=0&size=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[*].address", containsInAnyOrder("Address", "Address")))
                .andExpect(jsonPath("$[*].account", containsInAnyOrder(AccountStub.generateAccountDTO().toString(),
                        AccountStub.generateAccountDTO().toString())))
                .andExpect(jsonPath("$[*].totalSum", containsInAnyOrder(10, 10)))
                .andExpect(jsonPath("$[*].books", hasSize(2)))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(1, 2)));
    }

    @Test
    @WithMockUser(roles = {"ADMIN", "USER"})
    void get() throws Exception {
        var request = OrderStub.generateOrder();

        when(accountService.convertToDTOString(anyInt())).thenReturn(AccountStub.generateAccountDTO().toString());
        when(bookService.convertToDTOString(anyInt())).thenReturn(BookStub.generateBookDTO().toString());
        when(repository.getById(anyInt())).thenReturn(request);

        var expect = OrderStub.generateOrderDTO();

        mockMvc.perform(getRequest("/orders/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getAddress())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(AccountStub.generateAccountDTO().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(BookStub.generateBookDTO().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getTotalSum().toString())));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception {
        var request = OrderStub.generateOrderUpdateRequest();
        request.setAddress("New Address");

        var order = OrderStub.generateOrder();

        when(accountService.convertToDTOString(anyInt())).thenReturn(AccountStub.generateAccountDTO().toString());
        when(bookService.convertToDTOString(anyInt())).thenReturn(BookStub.generateBookDTO().toString());
        when(repository.getById(anyInt())).thenReturn(order);

        var expect = OrderStub.generateOrderDTO();

        order.setAddress("New Address");

        when(repository.save(any())).thenReturn(order);

        mockMvc.perform(putRequest("/orders/1", request))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(request.getAddress())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(AccountStub.generateAccountDTO().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(BookStub.generateBookDTO().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getTotalSum().toString())));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void create() throws Exception {
        var request = OrderStub.generateOrderCreateRequest();

        var expect = OrderStub.generateOrderDTO();

        var order = OrderStub.generateOrder();

        when(repository.save(any())).thenReturn(order);
        when(bookService.get(anyInt())).thenReturn(BookStub.generateBookDTO());
        when(accountService.convertToDTOString(anyInt())).thenReturn(AccountStub.generateAccountDTO().toString());
        when(bookService.convertToDTOString(anyInt())).thenReturn(BookStub.generateBookDTO().toString());

        mockMvc.perform(postRequest("/orders", request))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getAddress())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(expect.getTotalSum().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(AccountStub.generateAccountDTO().toString())))
                .andExpect(MockMvcResultMatchers.content().string(containsString(BookStub.generateBookDTO().toString())));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(deleteRequest("/orders/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(repository, atLeast(1)).deleteById(1);
    }
}