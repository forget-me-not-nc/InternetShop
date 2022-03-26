package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.user.req.UserModify;
import com.example.internetshop.DTO.user.resp.UserDTO;
import com.example.internetshop.services.user.impls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public ResponseEntity<List<UserDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(userService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserDTO> get(@PathVariable Integer id) throws Exception
	{
		return ResponseEntity.ok(userService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<UserDTO> update(@RequestBody UserModify entity) throws Exception
	{
		return ResponseEntity.ok(userService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<UserDTO> create(@RequestBody UserModify entity) throws Exception
	{
		return ResponseEntity.ok(userService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception
	{
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}