package com.example.internetshop.services.order.impls;

import com.example.internetshop.DTO.order.req.OrderCreate;
import com.example.internetshop.DTO.order.req.OrderUpdate;
import com.example.internetshop.DTO.order.resp.OrderDTO;
import com.example.internetshop.model.Account;
import com.example.internetshop.model.Order;
import com.example.internetshop.repositories.OrderRepository;
import com.example.internetshop.services.account.services.IAccountService;
import com.example.internetshop.services.book.services.IBookService;
import com.example.internetshop.services.order.services.IOrderService;
import com.example.internetshop.settings.ElementExceptionStrings;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Array;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:02
 * @Version OrderServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService
{
	private final OrderRepository repository;
	private final IBookService bookService;
	private final IAccountService accountService;

	@Override
	public Page<OrderDTO> getAll(Integer page, Integer size)
	{
		Page<Order> orders = repository.findAll(PageRequest.of(page, size));

		var ordersDTOs = orders.get().map(this::convertToDTO).collect(Collectors.toList());

		return new PageImpl<OrderDTO>(ordersDTOs);
	}

	@Override
	public OrderDTO get(Integer id) throws Exception
	{
		try
		{
			return convertToDTO(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Order.class, id));
		}
	}

	@Override
	public OrderDTO create(OrderCreate entity) throws Exception
	{
		try
		{
			return convertToDTO(
					repository.save(
							Order.builder()
									.totalSum(entity.getTotalSum())
									.account(Account.builder()
											.id(entity.getAccountId())
											.build())
									.address(entity.getAddress())
									.orderDate(LocalDateTime.now())
									.books(bindOrderWithBooks(entity.getBooksId()))
									.build()
							)
					);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(ElementExceptionStrings.getCreateExceptionString(entity));
		}
	}

	@Override
	public OrderDTO update(OrderUpdate entity) throws Exception
	{
		try
		{
			Order order = repository.getById(entity.getId());

			return convertToDTO(
					repository.save(
							Order.builder()
								.id(entity.getId())
								.totalSum(entity.getTotalSum())
								.address(entity.getAddress())
								.orderDate(order.getOrderDate())
								.books(order.getBooks())
								.account(order.getAccount())
								.build()
					)
			);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(ElementExceptionStrings.getUpdateExceptionString(entity));
		}
	}

	@Override
	public void delete(Integer id) throws Exception
	{
		try
		{
			repository.delete(repository.getById(id));
		}
		catch (Exception e)
		{
			throw new Exception(ElementExceptionStrings.getExceptionString(Order.class, id));
		}
	}

	private OrderDTO convertToDTO(Order entity)
	{
		List<String> books = Arrays.stream(entity.getBooks())
				.map(bookService::convertToDTOString)
				.collect(Collectors.toList());

		return OrderDTO.builder()
				.id(entity.getId())
				.orderDate(entity.getOrderDate())
				.totalSum(entity.getTotalSum())
				.address(entity.getAddress())
				.books(books)
				.account(accountService.convertToDTOString(entity.getAccount().getId()))
				.build();
	}

	private Integer[] bindOrderWithBooks(List<Integer> booksIds)
	{
		return booksIds.stream()
				.filter(
						item ->
						{
							try
							{
								bookService.get(item);

								return true;
							}
							catch (Exception e)
							{
								return false;
							}
						}
				).toArray(Integer[]::new);
	}
}