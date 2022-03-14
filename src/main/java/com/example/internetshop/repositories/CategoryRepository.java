package com.example.internetshop.repositories;

import com.example.internetshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:31
 * @Version CategoryRepository: 1.0
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
