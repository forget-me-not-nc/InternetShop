package com.example.internetshop.services.user.services;

import com.example.internetshop.DTO.user.req.UserModify;
import com.example.internetshop.DTO.user.resp.UserDTO;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IUserService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:02
 * @Version IUserService: 1.0
 */

public interface IUserService {
    Page<UserDTO> getAll(Integer page, Integer size);

    UserDTO get(Integer id);

    UserDTO create(UserModify entity);

    UserDTO update(UserModify entity);

    void delete(Integer id);
}