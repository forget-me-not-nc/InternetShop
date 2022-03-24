package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.User;
import com.example.internetshop.services.user.impls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.UserController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:49
 * @Version UserController: 1.0
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController
{
	private final UserServiceImpl userService;

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(userService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(userService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User entity)
	{
		return ResponseEntity.ok(userService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<User> create(@RequestBody User entity)
	{
		return ResponseEntity.ok(userService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}