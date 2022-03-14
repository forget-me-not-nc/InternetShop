package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.Order;
import com.example.internetshop.services.order.impls.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:49
 * @Version OrderController: 1.0
 */

@RestController("/orders")
@RequiredArgsConstructor
public class OrderController
{
	private final OrderServiceImpl orderService;

	@GetMapping("/getAll")
	public ResponseEntity<Page<Order>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(orderService.getAll(page, size));
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Order> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(orderService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Order> update(@RequestParam Order entity)
	{
		return ResponseEntity.ok(orderService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<Order> create(@RequestParam Order entity)
	{
		return ResponseEntity.ok(orderService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		orderService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}