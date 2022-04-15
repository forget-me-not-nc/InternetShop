package com.example.internetshop.stubs;

import com.example.internetshop.DTO.category.resp.CategoryDTO;
import com.example.internetshop.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryStub
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 07.04.2022|15:11
 * @Version CategoryStub: 1.0
 */

public final class CategoryStub {

    public static final Integer ID = 1;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Category generateCategory() {
        return Category.builder()
                .id(ID)
                .name("Name 1")
                .books(new ArrayList<>())
                .build();
    }

    public static CategoryDTO generateDTO() {
        return CategoryDTO.builder()
                .id(ID)
                .name("Name 1")
                .build();
    }

    public static CategoryDTO generateDTO_2() {
        return CategoryDTO.builder()
                .id(ID + 1)
                .name("Name 2")
                .build();
    }

    public static List<Category> generateCategoriesList() {
        return new ArrayList<>(
                Arrays.asList(
                        Category.builder()
                                .id(ID)
                                .name("Name 1")
                                .books(new ArrayList<>())
                                .build(),
                        Category.builder()
                                .id(ID + 1)
                                .name("Name 2")
                                .books(new ArrayList<>())
                                .build()
                )
        );
    }
}