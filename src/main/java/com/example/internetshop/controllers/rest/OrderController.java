package com.example.internetshop.controllers.rest;

import com.example.internetshop.services.order.impls.OrderServiceImpl;
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
	private final OrderServiceImpl orderService;

//	@GetMapping("/getAll")
//	public ResponseEntity<List<OrderDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
//	{
//		return ResponseEntity.ok(orderService.getAll(page, size).getContent());
//	}
//
//	@GetMapping("/get/{id}")
//	public ResponseEntity<OrderDTO> get(@PathVariable Integer id)
//	{
//		return ResponseEntity.ok(orderService.get(id));
//	}
//
//	@PutMapping("/update")
//	public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO entity)
//	{
//		return ResponseEntity.ok(orderService.update(entity));
//	}
//
//	@PutMapping("/create")
//	public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO entity)
//	{
//		return ResponseEntity.ok(orderService.create(entity));
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id)
//	{
//		orderService.delete(id);
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
}