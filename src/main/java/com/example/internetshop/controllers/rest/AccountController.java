package com.example.internetshop.controllers.rest;

import com.example.internetshop.model.Account;
import com.example.internetshop.services.account.impls.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
	private final AccountServiceImpl accountService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Account>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(accountService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Account> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(accountService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Account> update(@RequestBody Account entity)
	{
		return ResponseEntity.ok(accountService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<Account> create(@RequestBody Account entity)
	{
		return ResponseEntity.ok(accountService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		accountService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}