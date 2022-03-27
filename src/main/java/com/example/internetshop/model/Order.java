package com.example.internetshop.model;


import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Order
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Order: 1.0
 */

@Entity(name = "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime orderDate;
	private BigDecimal totalSum;
	private String address;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@Column(columnDefinition = "int[]")
	@Type(type = "com.example.internetshop.settings.CustomIntegerArrayType")
	private Integer[] books;

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return id.equals(order.id) && Objects.equals(orderDate, order.orderDate) && Objects.equals(totalSum, order.totalSum) && Objects.equals(address, order.address) && account.equals(order.account) && Arrays.equals(books, order.books);
	}

	@Override
	public int hashCode()
	{
		int result = Objects.hash(id, orderDate, totalSum, address, account);
		result = 31 * result + Arrays.hashCode(books);
		return result;
	}
}