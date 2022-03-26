package com.example.internetshop.DTO.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:10
 * @Version ClientDTO: 1.0
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private String phone;
	private String email;
}