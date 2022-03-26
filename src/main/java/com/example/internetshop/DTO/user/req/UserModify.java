package com.example.internetshop.DTO.user.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.UserModify
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:43
 * @Version UserModify: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserModify
{
	private Integer id;
	private String username;
	private String password;
}