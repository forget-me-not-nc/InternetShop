package com.example.internetshop.DTO.client.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientModify
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:44
 * @Version ClientModify: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientModify
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private String phone;
	private String email;
}