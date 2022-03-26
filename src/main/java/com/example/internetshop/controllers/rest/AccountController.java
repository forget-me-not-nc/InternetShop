package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.account.AccountCreateRequest;
import com.example.internetshop.DTO.account.AccountDTO;
import com.example.internetshop.DTO.account.AccountUpdateRequest;
import com.example.internetshop.services.account.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountController
{
	private IAccountService accountService;

	@Autowired
	public void setAccountService(IAccountService accountService)
	{
		this.accountService = accountService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<AccountDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(accountService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AccountDTO> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(accountService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<AccountDTO> update(@RequestBody AccountUpdateRequest entity)
	{
		return ResponseEntity.ok(accountService.update(
				AccountDTO.builder()
						.id(entity.getId())
						.isActive(entity.isActive())
						.balance(entity.getBalance())
						.build()
		));
	}

	@PutMapping("/create")
	public ResponseEntity<AccountDTO> create(@RequestBody AccountCreateRequest entity)
	{
		return ResponseEntity.ok(accountService.create(
				AccountDTO.builder()
						.userId(entity.getUserId())
						.clientId(entity.getClientId())
						.balance(entity.getBalance())
						.isActive(entity.isActive())
						.build()
		));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		accountService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}