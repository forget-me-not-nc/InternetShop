package com.example.internetshop.services.order.impls;

import com.example.internetshop.DTO.order.OrderDTO;
import com.example.internetshop.repositories.OrderRepository;
import com.example.internetshop.services.order.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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


	@Override
	public Page<OrderDTO> getAll(Integer page, Integer size)
	{
		return null;
	}

	@Override
	public OrderDTO get(Integer id)
	{
		return null;
	}

	@Override
	public OrderDTO update(OrderDTO orderDTO)
	{
		return null;
	}

	@Override
	public OrderDTO create(OrderDTO orderDTO)
	{
		return null;
	}

	@Override
	public void delete(Integer id)
	{

	}
}