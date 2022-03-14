package com.example.internetshop.services.order.impls;

import com.example.internetshop.model.Order;
import com.example.internetshop.repositories.OrderRepository;
import com.example.internetshop.services.order.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Order> getAll(Integer page, Integer size)
	{
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Order get(Integer id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public Order update(Order order)
	{
		return repository.save(order);
	}

	@Override
	public Order create(Order order)
	{
		return repository.save(order);
	}

	@Override
	public void delete(Integer id)
	{
		repository.delete(get(id));
	}
}
