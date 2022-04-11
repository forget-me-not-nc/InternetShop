package com.example.internetshop.stubs;

import com.example.internetshop.DTO.order.req.OrderCreate;
import com.example.internetshop.DTO.order.req.OrderUpdate;
import com.example.internetshop.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderStub
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 09.04.2022|12:53
 * @Version OrderStub: 1.0
 */

public final class OrderStub {
    public static final Integer ID = 1;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Order generateOrder()
    {
        return Order.builder()
                .id(ID)
                .account(AccountStub.generateAccount())
                .orderDate(LocalDateTime.now())
                .books(new Integer[]{1,2})
                .address("Address")
                .totalSum(BigDecimal.TEN)
                .build();
    }

    public static List<Order> generateOrdersList()
    {
        return new ArrayList<>(
                Arrays.asList(
                        Order.builder()
                                .id(ID)
                                .account(AccountStub.generateAccount())
                                .orderDate(LocalDateTime.now())
                                .books(new Integer[]{1,2})
                                .address("Address")
                                .totalSum(BigDecimal.TEN)
                                .build(),
                        Order.builder()
                                .id(ID + 1)
                                .account(AccountStub.generateAccount())
                                .orderDate(LocalDateTime.now())
                                .books(new Integer[]{1,2})
                                .address("Address")
                                .totalSum(BigDecimal.TEN)
                                .build()
                )
        );
    }

    public static OrderCreate generateOrderCreateRequest()
    {
        return OrderCreate.builder()
                .id(ID)
                .accountId(AccountStub.ID)
                .address("Address")
                .booksId(new ArrayList<>())
                .totalSum(BigDecimal.TEN)
                .build();
    }

    public static OrderUpdate generateOrderUpdateRequest()
    {
        return OrderUpdate.builder()
                .id(ID)
                .address("Address")
                .totalSum(BigDecimal.TEN)
                .build();
    }
}