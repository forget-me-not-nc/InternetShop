package com.example.internetshop.DTO.client.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:44
 * @Version ClientDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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