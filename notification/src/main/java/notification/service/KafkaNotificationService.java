package notification.service;

import notification.repository.NotificationRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.domain.dto.OrderDTO;
import ru.job4j.domain.model.Notification;

import java.util.List;

@Service
public class KafkaNotificationService {
    private final NotificationRepository notificationRepository;

    public KafkaNotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @KafkaListener(topics = {"notificationsOrder"})
    public void consume(ConsumerRecord<Integer, OrderDTO> input) {
        OrderDTO dto = input.value();
        notificationRepository.save(new Notification(dto.getId(),
                String.format("Заказ с статусом %s -> Принят, id = %s.", dto.getStatus(), dto.getId())));
    }
}
