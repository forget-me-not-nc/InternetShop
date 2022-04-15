package com.example.internetshop.stubs;

import com.example.internetshop.DTO.account.req.AccountCreate;
import com.example.internetshop.DTO.account.req.AccountUpdate;
import com.example.internetshop.DTO.account.resp.AccountDTO;
import com.example.internetshop.model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountStub
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 09.04.2022|12:55
 * @Version AccountStub: 1.0
 */

public final class AccountStub {
    public static final Integer ID = 1;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Account generateAccount() {
        return Account.builder()
                .id(ID)
                .user(UserStub.generateUser())
                .client(ClientStub.generateClient())
                .balance(BigDecimal.TEN)
                .isActive(true)
                .order(new ArrayList<>())
                .build();
    }

    public static List<Account> generateAccountsList() {
        return new ArrayList<>(
                Arrays.asList(
                        Account.builder()
                                .id(ID)
                                .user(UserStub.generateUser())
                                .client(ClientStub.generateClient())
                                .balance(BigDecimal.TEN)
                                .isActive(true)
                                .order(new ArrayList<>())
                                .build(),
                        Account.builder()
                                .id(ID + 1)
                                .user(UserStub.generateUser())
                                .client(ClientStub.generateClient())
                                .balance(BigDecimal.TEN)
                                .isActive(true)
                                .order(new ArrayList<>())
                                .build()
                )
        );
    }

    public static AccountUpdate generateAccountUpdate() {
        return AccountUpdate.builder()
                .id(ID)
                .balance(BigDecimal.TEN)
                .isActive(true)
                .build();
    }

    public static AccountCreate generateAccountCreate() {
        return AccountCreate.builder()
                .balance(BigDecimal.TEN)
                .isActive(true)
                .email("Email")
                .firstName("FirstName")
                .lastName("LastName")
                .login("Login")
                .password("Password")
                .phone("Phone")
                .build();
    }

    public static AccountDTO generateAccountDTO() {
        return AccountDTO.builder()
                .balance(BigDecimal.TEN)
                .isActive(true)
                .id(ID)
                .userId(UserStub.generateUser().getId())
                .clientId(ClientStub.generateClient().getId())
                .build();
    }
}