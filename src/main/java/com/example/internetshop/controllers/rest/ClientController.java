package com.example.internetshop.controllers.rest;

import com.example.internetshop.DTO.client.ClientDTO;
import com.example.internetshop.services.client.impls.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientController
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|15:48
 * @Version ClientController: 1.0
 */

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController
{
	private final ClientServiceImpl clientService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ClientDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size)
	{
		return ResponseEntity.ok(clientService.getAll(page, size).getContent());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ClientDTO> get(@PathVariable Integer id)
	{
		return ResponseEntity.ok(clientService.get(id));
	}

	@PutMapping("/update")
	public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO entity)
	{
		return ResponseEntity.ok(clientService.update(entity));
	}

	@PutMapping("/create")
	public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO entity)
	{
		return ResponseEntity.ok(clientService.create(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		clientService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}