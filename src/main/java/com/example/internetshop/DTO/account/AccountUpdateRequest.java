package com.example.internetshop.DTO.account;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountUpdateReqeust
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|14:58
 * @Version AccountUpdateReqeust: 1.0
 */

@Builder
@Data
public class AccountUpdateRequest
{
	private Integer id;
	private boolean isActive;
	private BigDecimal balance;
}