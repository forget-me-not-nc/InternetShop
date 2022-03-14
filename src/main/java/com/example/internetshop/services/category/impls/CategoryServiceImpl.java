package com.example.internetshop.services.category.impls;

import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.services.category.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Category> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Category get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public Category update(Category category)
	{
		return repository.save(category);
	}

	@Override
	public Category create(Category category)
	{
		return repository.save(category);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
