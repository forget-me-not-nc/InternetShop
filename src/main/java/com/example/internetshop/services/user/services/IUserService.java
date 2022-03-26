package com.example.internetshop.services.user.services;

import com.example.internetshop.DTO.user.SimplifiedUser;
import com.example.internetshop.DTO.user.UserDTO;
import com.example.internetshop.model.User;
import com.example.internetshop.services.IGenericService;
import com.example.internetshop.services.account.services.IAccountService;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IUserService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:02
 * @Version IUserService: 1.0
 */

public interface IUserService extends IGenericService<UserDTO>
{
	SimplifiedUser simplifieUser(UserDTO user);

	User getUser(Integer id);

}