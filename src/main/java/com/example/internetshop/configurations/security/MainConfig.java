package com.example.internetshop.configurations.security;

import lombok.RequiredArgsConstructor;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.modelmapper.ModelMapper;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.MainConfig
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|2:31
 * @Version MainConfig: 1.0
 */

@Configuration
@RequiredArgsConstructor
public class MainConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }
}