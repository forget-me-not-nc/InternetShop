package com.example.internetshop.DTO.book.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|13:28
 * @Version BookDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDTO
{
	private Integer id;
	private BigDecimal price;
	private String name;


}