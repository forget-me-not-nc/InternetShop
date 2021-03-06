package com.example.internetshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String info;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}