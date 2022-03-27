package com.example.internetshop.DTO.category.resp;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CategoryDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|13:59
 * @Version CategoryDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDTO
{
	private Integer id;
	private String name;

	@Override
	public String toString()
	{
		return "CategoryDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}