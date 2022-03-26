package com.example.internetshop.DTO.account;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:09
 * @Version AccountDTO: 1.0
 */

@Builder
@Data
public class AccountDTO
{
	private Integer id;
	private boolean isActive;
	private BigDecimal balance;

	private Integer userId;
	private Integer clientId;
}