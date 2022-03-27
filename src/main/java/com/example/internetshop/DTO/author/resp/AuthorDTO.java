package com.example.internetshop.DTO.author.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorDTO
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 27.03.2022|13:58
 * @Version AuthorDTO: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorDTO
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;

	@Override
	public String toString()
	{
		return "AuthorDTO{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				'}';
	}
}