package com.example.internetshop.DTO.security.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.SignUpRequest
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:42
 * @Version SignUpRequest: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private String username;
    private String password;
    private List<String> roles;
}