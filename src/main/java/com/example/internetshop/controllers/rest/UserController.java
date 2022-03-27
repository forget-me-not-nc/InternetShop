package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.user.req.UserModify;
import com.example.internetshop.DTO.user.resp.UserDTO;
import com.example.internetshop.model.Client;
import com.example.internetshop.services.account.services.IAccountService;
import com.example.internetshop.services.client.services.IClientService;
import com.example.internetshop.services.user.services.IUserService;
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
	private final IUserService userService;
	private final IAccountService accountService;
	private final IClientService clientService;

	@GetMapping()
	public ResponseEntity<List<UserDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(userService.getAll(page, size).getContent());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> get(@PathVariable Integer id) throws Exception
	{
		return ResponseEntity.ok(userService.get(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserModify entity) throws Exception
	{
		entity.setId(id);
		return ResponseEntity.ok(userService.update(entity));
	}

	@PutMapping()
	public ResponseEntity<UserDTO> create(@RequestBody UserModify entity) throws Exception
	{
		return ResponseEntity.ok(userService.create(entity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception
	{
		Client client = accountService.findClientByUserId(id);

		if (client != null) clientService.delete(client.getId());

		userService.delete(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

}