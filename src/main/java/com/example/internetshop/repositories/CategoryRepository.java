package com.example.internetshop.repositories;

import com.example.internetshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:31
 * @Version CategoryRepository: 1.0
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT * FROM categories WHERE id IN (SELECT category_id FROM book_has_category WHERE book_id = :bookId);", nativeQuery = true)
    Optional<List<Category>> getBookCategoriesNames(Integer bookId);
}