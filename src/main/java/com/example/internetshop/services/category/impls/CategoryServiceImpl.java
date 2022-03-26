package com.example.internetshop.services.category.impls;

import com.example.internetshop.DTO.category.CategoryDTO;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.services.category.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:58
 * @Version CategoryServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService
{

	private final CategoryRepository repository;


	@Override
	public Page<CategoryDTO> getAll(Integer page, Integer size)
	{
		return null;
	}

	@Override
	public CategoryDTO get(Integer id)
	{
		return null;
	}

	@Override
	public CategoryDTO update(CategoryDTO categoryDTO)
	{
		return null;
	}

	@Override
	public CategoryDTO create(CategoryDTO categoryDTO)
	{
		return null;
	}

	@Override
	public void delete(Integer id)
	{

	}
}