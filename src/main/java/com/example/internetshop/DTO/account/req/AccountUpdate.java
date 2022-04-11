package com.example.internetshop.DTO.account.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountUpdate
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:12
 * @Version AccountUpdate: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountUpdate {
    private Integer id;
    private boolean isActive;
    private BigDecimal balance;
}