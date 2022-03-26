package com.example.internetshop.DTO.user;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.SimplifiedUser
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|13:18
 * @Version SimplifiedUser: 1.0
 */

@Builder
@Data
public class SimplifiedUser
{
	private Integer id;
	private String login;
}