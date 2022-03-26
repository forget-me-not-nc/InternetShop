package com.example.internetshop.DTO.category;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:10
 * @Version CategoryDTO: 1.0
 */

@Builder
@Data
public class CategoryDTO
{
	private Integer id;
	private String name;
}