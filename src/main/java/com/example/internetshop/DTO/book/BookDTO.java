package com.example.internetshop.DTO.book;

import com.example.internetshop.DTO.author.SimplifiedAuthor;
import com.example.internetshop.DTO.category.SimplifiedCategory;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:10
 * @Version BookDTO: 1.0
 */

@Builder
@Data
public class BookDTO
{
	private Integer id;
	private BigDecimal price;
	private String name;
	private String publishingHouse;

	private List<SimplifiedAuthor> authors;
	private List<SimplifiedCategory> categories;
}