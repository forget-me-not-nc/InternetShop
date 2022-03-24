package com.example.internetshop.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.User
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version User: 1.0
 */

@Entity(name = "users")
@Data
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String password;

	@OneToOne(mappedBy = "user")
	private Account account;
}