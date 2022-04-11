package com.example.internetshop.services.category.services;

import com.example.internetshop.DTO.category.resp.CategoryDTO;
import com.example.internetshop.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ICategoryService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:58
 * @Version ICategoryService: 1.0
 */

public interface ICategoryService {
    Page<CategoryDTO> getAll(Integer page, Integer size);

    CategoryDTO get(Integer id);

    CategoryDTO create(CategoryDTO entity);

    CategoryDTO update(CategoryDTO entity);

    void delete(Integer id);

    CategoryDTO convertToDTO(Category entity);

    CategoryDTO convertToDTO(Integer categoryId);

    List<String> getCategoriesNamesByBookId(Integer bookId);
}