package com.example.internetshop.services.account.services;

import com.example.internetshop.DTO.account.req.AccountCreate;
import com.example.internetshop.DTO.account.req.AccountUpdate;
import com.example.internetshop.DTO.account.resp.AccountDTO;
import com.example.internetshop.model.Client;
import com.example.internetshop.model.User;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IAccountService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:54
 * @Version IAccountService: 1.0
 */

public interface IAccountService
{
	Page<AccountDTO> getAll(Integer page, Integer size);

	AccountDTO get(Integer id) throws Exception;

	AccountDTO create(AccountCreate entity) throws Exception;

	AccountDTO update(AccountUpdate entity) throws Exception;

	void delete(Integer id) throws Exception;

	Client findClientByUserId(Integer id);

	User findUserByClientId(Integer id);

}