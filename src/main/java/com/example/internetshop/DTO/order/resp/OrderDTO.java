package com.example.internetshop.DTO.order.resp;

import com.example.internetshop.DTO.account.resp.AccountDTO;
import com.example.internetshop.DTO.book.resp.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|16:34
 * @Version OrderDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO
{
	private Integer id;
	private LocalDateTime orderDate;
	private BigDecimal totalSum;
	private String address;

	private String account;

	private List<String> books;

	@Override
	public String toString()
	{
		return "OrderDTO{" +
				"id=" + id +
				", orderDate=" + orderDate +
				", totalSum=" + totalSum +
				", address='" + address + '\'' +
				", account='" + account + '\'' +
				", books=" + books +
				'}';
	}
}