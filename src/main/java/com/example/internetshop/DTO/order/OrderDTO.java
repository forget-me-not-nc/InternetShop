package com.example.internetshop.DTO.order;

import com.example.internetshop.DTO.account.AccountDTO;
import com.example.internetshop.DTO.book.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:10
 * @Version OrderDTO: 1.0
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO
{
	private Integer id;
	private LocalDateTime orderDate;
	private BigDecimal totalSum;
	private String address;

	private List<BookDTO> books;
	private AccountDTO account;
}