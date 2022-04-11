package com.example.internetshop.DTO.user.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.UserDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|22:42
 * @Version UserDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private Integer id;
    private String username;
}