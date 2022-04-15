package com.example.internetshop.configuration;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ServletRequestConfig
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|1:41
 * @Version ServletRequestConfig: 1.0
 */

public final class ServletRequestConfig {

    public static MockHttpServletRequestBuilder postRequest(String url, Object request) {
        return post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(CustomObjectMapper.asJsonString(request));
    }

    public static MockHttpServletRequestBuilder putRequest(String url, Object request) {
        return put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(CustomObjectMapper.asJsonString(request));
    }

    public static MockHttpServletRequestBuilder getRequest(String url) {
        return get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    public static MockHttpServletRequestBuilder deleteRequest(String url) {
        return delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

}