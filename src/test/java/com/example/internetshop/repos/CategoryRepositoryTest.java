package com.example.internetshop.repos;

import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.stubs.CategoryStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

    private final Integer bookId = 1;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void successGetBookCategoriesNames() {
        List<Category> expect = new ArrayList<>(
                Arrays.asList(
                        Category.builder()
                                .name("Name 1")
                                .build(),
                        Category.builder()
                                .name("Name 2")
                                .build()
                )
        );

        entityManager.persist(expect);
        entityManager.flush();

        var actualResult = categoryRepository.getBookCategoriesNames(bookId);

        Assertions.assertThat(actualResult.isPresent()).isEqualTo(true);
        Assertions.assertThat(actualResult.get()).isEqualTo(expect);
    }

    @Test
    void failedGetBookCategoriesNames() {
        Category fdf = Category.builder()
                        .name("Name 1")
                        .build();
        List<Category> expect = new ArrayList<>(
                Arrays.asList(
                        Category.builder()
                                .books(new ArrayList<>())
                                .name("Name 1")
                                .build(),
                        Category.builder()
                                .books(new ArrayList<>())
                                .name("Name 2")
                                .build()
                )
        );

        entityManager.persist(fdf);
        entityManager.flush();

        var actualResult = categoryRepository.getBookCategoriesNames(bookId + 1);

        Assertions.assertThat(actualResult.isPresent()).isEqualTo(false);
    }
}