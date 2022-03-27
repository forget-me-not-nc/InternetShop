package com.example.internetshop.services.category.impls;

import com.example.internetshop.DTO.category.resp.CategoryDTO;
import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.services.category.services.ICategoryService;
import com.example.internetshop.settings.ElementExceptionStrings;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
		Page<Category> categories = repository.findAll(PageRequest.of(page, size));

		var categoryDTOs = categories.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<CategoryDTO>(categoryDTOs);
	}

	@Override
	public CategoryDTO get(Integer id) throws Exception
	{
		try
		{
			return convertToDTO(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Category.class, id));
		}
	}

	@Override
	public CategoryDTO create(CategoryDTO entity) throws Exception
	{
		try
		{
			return convertToDTO(repository.save(
					Category.builder()
							.name(entity.getName())
							.build()
			));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getCreateExceptionString(entity));
		}
	}

	@Override
	public CategoryDTO update(CategoryDTO entity) throws Exception
	{
		try
		{
			return convertToDTO(repository.save(
					Category.builder()
							.id(entity.getId())
							.name(entity.getName())
							.build()
			));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getUpdateExceptionString(entity));
		}
	}

	@Override
	public void delete(Integer id) throws Exception
	{
		try
		{
			repository.delete(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Category.class, id));
		}
	}

	@Override
	public CategoryDTO convertToDTO(Category entity)
	{
		return CategoryDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.build();
	}

	@Override
	public CategoryDTO convertToDTO(Integer categoryId)
	{
		Category category = repository.getById(categoryId);

		return CategoryDTO.builder()
				.name(category.getName())
				.id(categoryId)
				.build();
	}
}