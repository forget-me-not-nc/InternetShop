package com.example.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Account
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Account: 1.0
 */

@Entity(name = "accounts")
@Data
public class Account
{
    @Id
    private Long id;
    private boolean isActive;
    private BigDecimal balance;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @OneToOne
//    @JoinColumn(name = "client_id")
//    private Client client;

//    @OneToMany(mappedBy = "account")
//    private List<Order> order;
}
