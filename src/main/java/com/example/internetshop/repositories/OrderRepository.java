package com.example.internetshop.repositories;

import com.example.internetshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:31
 * @Version OrderRepository: 1.0
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
}