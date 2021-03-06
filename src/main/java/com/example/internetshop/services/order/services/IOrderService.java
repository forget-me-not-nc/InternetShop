package com.example.internetshop.services.order.services;

import com.example.internetshop.DTO.order.req.OrderCreate;
import com.example.internetshop.DTO.order.req.OrderUpdate;
import com.example.internetshop.DTO.order.resp.OrderDTO;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IOrderService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:01
 * @Version IOrderService: 1.0
 */

public interface IOrderService {
    Page<OrderDTO> getAll(Integer page, Integer size);

    OrderDTO get(Integer id);

    OrderDTO create(OrderCreate entity);

    OrderDTO update(OrderUpdate entity);

    void delete(Integer id);
}