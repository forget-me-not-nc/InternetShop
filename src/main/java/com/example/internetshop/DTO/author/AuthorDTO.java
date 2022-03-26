package com.example.internetshop.DTO.author;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 24.03.2022|23:10
 * @Version AuthorDTO: 1.0
 */

@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class AuthorDTO
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String info;
}