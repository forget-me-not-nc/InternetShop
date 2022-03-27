package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.account.req.AccountCreate;
import com.example.internetshop.DTO.account.req.AccountUpdate;
import com.example.internetshop.DTO.account.resp.AccountDTO;
import com.example.internetshop.services.account.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:48
 * @Version AccountController: 1.0
 */

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController
{
	private final IAccountService accountService;

	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(accountService.getAll(page, size).getContent());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> get(@PathVariable Integer id) throws Exception
	{
		return ResponseEntity.ok(accountService.get(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDTO> update(@PathVariable Integer id, @RequestBody AccountUpdate entity) throws Exception
	{
		entity.setId(id);
		return ResponseEntity.ok(accountService.update(entity));
	}

	@PutMapping
	public ResponseEntity<AccountDTO> create(@RequestBody AccountCreate entity) throws Exception
	{
		return ResponseEntity.ok(accountService.create(entity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception
	{
		accountService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}