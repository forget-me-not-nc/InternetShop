package com.example.internetshop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Category
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Category: 1.0
 */

@Entity(name = "categories")
@Data
public class Category
{
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
