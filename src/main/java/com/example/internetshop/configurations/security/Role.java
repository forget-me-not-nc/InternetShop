package com.example.internetshop.configurations.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Role
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:53
 * @Version Role: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }
}