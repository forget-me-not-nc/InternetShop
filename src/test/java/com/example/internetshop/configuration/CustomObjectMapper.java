package com.example.internetshop.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CustomObjectMapper
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|1:35
 * @Version CustomObjectMapper: 1.0
 */

public final class CustomObjectMapper {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}