package notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@EntityScan(basePackages = "ru.job4j.domain")
public class NotificationService {
    public static void main(String[] args) {
        SpringApplication.run(NotificationService.class);
    }
}
