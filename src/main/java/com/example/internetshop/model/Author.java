package com.example.internetshop.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Author
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|18:08
 * @Version Author: 1.0
 */

@Entity(name = "authors")
@Data
public class Author
{
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String info;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
