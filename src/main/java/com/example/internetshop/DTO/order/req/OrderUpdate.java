package com.example.internetshop.DTO.order.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderUpdate
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|16:33
 * @Version OrderUpdate: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderUpdate {
    private Integer id;
    private BigDecimal totalSum;
    private String address;
}