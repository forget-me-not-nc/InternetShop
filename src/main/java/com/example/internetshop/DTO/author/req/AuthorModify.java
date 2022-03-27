package com.example.internetshop.DTO.author.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorModify
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|14:02
 * @Version AuthorModify: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorModify
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String info;
}