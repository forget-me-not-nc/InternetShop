package com.example.internetshop.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.UserDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:09
 * @Version UserDTO: 1.0
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO
{
	private Integer id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
}