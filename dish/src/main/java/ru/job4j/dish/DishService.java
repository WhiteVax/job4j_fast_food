package ru.job4j.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ru.job4j.domain.model")
public class DishService {
    public static void main(String[] args) {
        SpringApplication.run(DishService.class);
    }
}
