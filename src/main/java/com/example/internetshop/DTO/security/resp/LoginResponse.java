package com.example.internetshop.DTO.security.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.LoginResponse
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:42
 * @Version LoginResponse: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String jwt;
    private String username;
    private List<String> roles;
}