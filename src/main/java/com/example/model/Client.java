package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Client
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Client: 1.0
 */

@Entity(name = "clients")
@Data
public class Client
{
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String address;
    private String phone;
    private String email;

//    @OneToOne(mappedBy = "client")
//    private Account account;
}
