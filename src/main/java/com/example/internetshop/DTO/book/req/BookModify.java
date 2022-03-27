package com.example.internetshop.DTO.book.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookModify
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|13:28
 * @Version BookModify: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookModify
{
	List<Integer> authors;
	List<Integer> categories;
	private Integer id;
	private BigDecimal price;
	private String name;
	private String publishingHouse;
}