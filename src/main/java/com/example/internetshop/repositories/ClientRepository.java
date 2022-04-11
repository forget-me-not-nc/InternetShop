package com.example.internetshop.repositories;

import com.example.internetshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:31
 * @Version ClientRepository: 1.0
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}