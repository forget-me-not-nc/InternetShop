package com.example.internetshop.DTO.account.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountCreate
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:08
 * @Version AccountCreate: 1.0
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountCreate {
    private boolean isActive;
    private BigDecimal balance;

    private String login;
    private String password;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}