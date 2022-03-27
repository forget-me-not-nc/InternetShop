package com.example.internetshop.settings;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ElementNotFoundExceptionString
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 26.03.2022|23:32
 * @Version ElementNotFoundExceptionString: 1.0
 */

public class ElementExceptionStrings
{
	public static String getCreateExceptionString(Object o)
	{
		return "Failed to create " + o.getClass() + " " + o + "!.";
	}

	public static String getUpdateExceptionString(Object o)
	{
		return "Failed to update " + o.getClass() + " " + o + "!.";
	}

	public static String getExceptionString(Object o, Integer id)
	{
		return "Failed to find " + o.getClass() + " with id:" + id + "!.";
	}
}