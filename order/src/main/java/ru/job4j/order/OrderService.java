package ru.job4j.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@EntityScan(basePackages = "ru.job4j.domain.model")
public class OrderService {
    public static void main(String[] args) {
        SpringApplication.run(OrderService.class);
    }
}
