package com.example.internetshop.DTO.security.req;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.LoginRequest
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:58
 * @Version LoginRequest: 1.0
 */

@Data
public class LoginRequest {
    private String username;
    private String password;
}