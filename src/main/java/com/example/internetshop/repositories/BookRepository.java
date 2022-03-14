package com.example.internetshop.repositories;

import com.example.internetshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookRepository
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:31
 * @Version BookRepository: 1.0
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{

}
