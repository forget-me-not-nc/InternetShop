package com.example.internetshop.DTO.author;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.SimplifiedAuthor
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|13:16
 * @Version SimplifiedAuthor: 1.0
 */

@Builder
@Data
public class SimplifiedAuthor
{
	private String firstName;
	private String lastName;
	private String middleName;
}