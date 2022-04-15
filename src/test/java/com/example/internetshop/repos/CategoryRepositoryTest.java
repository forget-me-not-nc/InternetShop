package com.example.internetshop.repos;

import com.example.internetshop.model.Book;
import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class CategoryRepositoryTest {

    @Container
    public static PostgreSQLContainer<?> postgreDBContainer = new PostgreSQLContainer<>("postgres:9.4")
            .withDatabaseName("internetShop")
            .withUsername("postgres")
            .withPassword("admin")
            .withExposedPorts(5432);
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void getBookCategoriesNames() {
        insertCategories();
        insertBooks();
        Optional<List<Category>> list = categoryRepository.getBookCategoriesNames(1);
        assertThat(list.isPresent()).isEqualTo(true);
        assertThat(list.get().size()).isEqualTo(2);
    }

    private void insertCategories() {
        categoryRepository.save(Category.builder()
                .id(1)
                .name("Name 1")
                .build());
        categoryRepository.save(Category.builder()
                .id(2)
                .name("Name 2")
                .build());
        categoryRepository.flush();
    }

    private void insertBooks() {
        bookRepository.save(Book.builder()
                .authors(new ArrayList<>())
                .categories(new ArrayList<>(
                        Arrays.asList(
                                Category.builder()
                                        .id(1)
                                        .name("Name 1")
                                        .build(),
                                Category.builder()
                                        .id(2)
                                        .name("Name 2")
                                        .build()
                        )

                ))
                .publishingHouse("PH")
                .id(1)
                .price(BigDecimal.TEN)
                .name("Book")
                .build());
        bookRepository.flush();
    }
}