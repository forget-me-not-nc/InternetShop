package com.example.internetshop.repositories;

import com.example.internetshop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:30
 * @Version AuthorRepository: 1.0
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}