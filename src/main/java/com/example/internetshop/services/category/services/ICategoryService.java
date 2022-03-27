package com.example.internetshop.services.category.services;

import com.example.internetshop.DTO.author.req.AuthorModify;
import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.DTO.category.resp.CategoryDTO;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ICategoryService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:58
 * @Version ICategoryService: 1.0
 */

public interface ICategoryService
{
	Page<CategoryDTO> getAll(Integer page, Integer size);

	CategoryDTO get(Integer id) throws Exception;

	CategoryDTO create(CategoryDTO entity) throws Exception;

	CategoryDTO update(CategoryDTO entity) throws Exception;

	void delete(Integer id) throws Exception;
}