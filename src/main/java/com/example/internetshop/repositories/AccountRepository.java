package com.example.internetshop.repositories;

import com.example.internetshop.model.Account;
import com.example.internetshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AccountRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:30
 * @Version AccountRepository: 1.0
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
	Account findByUserId(Integer id);
	Account findByClientId(Integer id);
}