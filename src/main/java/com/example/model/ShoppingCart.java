package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ShoppingCart
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version ShoppingCart: 1.0
 */

@Data
public class ShoppingCart
{
    private List<Book> selectedBooks;
    private BigDecimal currentSum;
}
