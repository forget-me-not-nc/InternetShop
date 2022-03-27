package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.order.req.OrderCreate;
import com.example.internetshop.DTO.order.req.OrderUpdate;
import com.example.internetshop.DTO.order.resp.OrderDTO;
import com.example.internetshop.services.order.impls.OrderServiceImpl;
import com.example.internetshop.services.order.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:49
 * @Version OrderController: 1.0
 */

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController
{
	private final IOrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(orderService.getAll(page, size).getContent());
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> get(@PathVariable Integer id) throws Exception
	{
		return ResponseEntity.ok(orderService.get(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderDTO> update(@PathVariable Integer id, @RequestBody OrderUpdate entity) throws Exception
	{
		entity.setId(id);
		return ResponseEntity.ok(orderService.update(entity));
	}

	@PutMapping
	public ResponseEntity<OrderDTO> create(@RequestBody OrderCreate entity) throws Exception
	{
		return ResponseEntity.ok(orderService.create(entity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception
	{
		orderService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}