package com.example.internetshop.DTO.order.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderCreate
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|16:33
 * @Version OrderCreate: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderCreate
{
	private Integer id;
	private BigDecimal totalSum;
	private String address;

	private Integer accountId;

	private List<Integer> booksId;
}