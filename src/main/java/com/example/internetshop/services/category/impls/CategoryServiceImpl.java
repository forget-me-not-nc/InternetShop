package com.example.internetshop.services.category.impls;

import com.example.internetshop.DTO.category.resp.CategoryDTO;
import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.services.category.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository repository;

    @Override
    public Page<CategoryDTO> getAll(Integer page, Integer size) {
        Page<Category> categories = repository.findAll(PageRequest.of(page, size));

        var categoryDTOs = categories.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<CategoryDTO>(categoryDTOs);
    }

    @Override
    public CategoryDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public CategoryDTO create(CategoryDTO entity) {
        return convertToDTO(repository.save(
                Category.builder()
                        .name(entity.getName())
                        .build())
        );
    }

    @Override
    public CategoryDTO update(CategoryDTO entity) {
        return convertToDTO(repository.save(
                Category.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .build()
        ));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryDTO convertToDTO(Category entity) {
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public CategoryDTO convertToDTO(Integer categoryId) {
        Category category = repository.getById(categoryId);

        return CategoryDTO.builder()
                .name(category.getName())
                .id(categoryId)
                .build();
    }

    @Override
    public List<String> getCategoriesNamesByBookId(Integer bookId) {
        Optional<List<Category>> list = repository.getBookCategoriesNames(bookId);

        return list.map(categories -> categories.stream().map(Category::getName).collect(Collectors.toList())).orElseGet(ArrayList::new);
    }
}