package com.example.internetshop.services.order.impls;

import com.example.internetshop.repositories.OrderRepository;
import com.example.internetshop.services.order.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.OrderServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:02
 * @Version OrderServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService
{

	private final OrderRepository repository;


}