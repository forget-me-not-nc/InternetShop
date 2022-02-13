package com.example.model;

import lombok.Data;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Order
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Order: 1.0
 */

@Entity(name = "orders")
@Data
public class Order
{
    @Id
    private Long id;
    private LocalDateTime orderDate;
    private BigDecimal totalSum;
    private String address;

//    @ManyToOne
//    @JoinColumn(name = "account_id")
//    private Account account;
//
//    @Type(type = "list-array")
//    @Column(
//            name = "books_ids",
//            columnDefinition = "text[]"
//    )
//    private List<String> books;
}
