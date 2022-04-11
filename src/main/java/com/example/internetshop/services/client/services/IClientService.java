package com.example.internetshop.services.client.services;

import com.example.internetshop.DTO.client.req.ClientModify;
import com.example.internetshop.DTO.client.resp.ClientDTO;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IClientService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:00
 * @Version IClientService: 1.0
 */

public interface IClientService {
    Page<ClientDTO> getAll(Integer page, Integer size);

    ClientDTO get(Integer id);

    ClientDTO create(ClientModify entity);

    ClientDTO update(ClientModify entity);

    void delete(Integer id);
}