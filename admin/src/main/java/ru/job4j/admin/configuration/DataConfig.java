package ru.job4j.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DataConfig {

    @Bean
    public RestTemplate init() {
        return new RestTemplate();
    }
}
