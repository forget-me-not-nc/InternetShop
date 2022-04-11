package com.example.internetshop.DTO.book.resp;

import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.DTO.category.resp.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|13:28
 * @Version BookDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDTO {
    List<AuthorDTO> authors;
    List<CategoryDTO> categories;
    private Integer id;
    private BigDecimal price;
    private String name;

    @Override
    public String toString() {
        return "BookDTO{" +
                "authors=" + authors +
                ", categories=" + categories +
                ", id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}