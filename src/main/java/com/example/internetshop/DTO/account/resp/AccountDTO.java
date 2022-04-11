package com.example.internetshop.DTO.account.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:07
 * @Version AccountDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountDTO {
    private Integer id;
    private boolean isActive;
    private BigDecimal balance;

    private Integer userId;
    private Integer clientId;

    @Override
    public String toString() {
        return "Account {" +
                "id=" + id +
                ", isActive=" + isActive +
                ", balance=" + balance +
                ", userId=" + userId +
                ", clientId=" + clientId +
                '}';
    }
}