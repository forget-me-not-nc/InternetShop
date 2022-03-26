package com.example.internetshop.DTO.account;

import com.example.internetshop.DTO.client.ClientDTO;
import com.example.internetshop.DTO.user.SimplifiedUser;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountDTO1
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|15:10
 * @Version AccountDTO1: 1.0
 */

@Builder
@Data
public class SimplifiedAccount
{
	private Integer id;
	private boolean isActive;
	private BigDecimal balance;

	private SimplifiedUser user;
	private ClientDTO client;
}