package com.example.internetshop.configurations.security;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CacheConfig
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:32
 * @Version CacheConfig: 1.0
 */

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {
    @Value("${cache.expiration}")
    private long expiration;

    @Override
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String name) {
                return new ConcurrentMapCache(
                        name,
                        CacheBuilder.newBuilder()
                                .expireAfterWrite(expiration, TimeUnit.MINUTES)
                                .build().asMap(),
                        false);

            }
        };
    }
}