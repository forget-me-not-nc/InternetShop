package com.example.internetshop.DTO.account;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountUpdateCreateRequest
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|14:08
 * @Version AccountUpdateCreateRequest: 1.0
 */

@Builder
@Data
public class AccountCreateRequest
{
	private boolean isActive;
	private BigDecimal balance;

	private Integer userId;
	private Integer clientId;
}