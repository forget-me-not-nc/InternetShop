package com.example.internetshop.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Order
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Order: 1.0
 */

@Entity(name = "orders")
@Data
public class Order
{
    @Id
    private Integer id;
    private LocalDateTime orderDate;
    private BigDecimal totalSum;
    private String address;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(columnDefinition = "int[]")
    @Type(type = "com.example.internetshop.settings.CustomIntegerArrayType")
    private Integer[] books;
}
