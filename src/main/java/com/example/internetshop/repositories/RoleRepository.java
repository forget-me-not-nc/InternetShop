package com.example.internetshop.repositories;

import com.example.internetshop.configurations.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.RoleRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:55
 * @Version RoleRepository: 1.0
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Role.ERole name);
}