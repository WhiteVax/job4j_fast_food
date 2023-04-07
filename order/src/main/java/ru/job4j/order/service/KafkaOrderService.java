package ru.job4j.order.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.job4j.domain.dto.OrderDTO;
import ru.job4j.domain.model.Order;

@Service
public class KafkaOrderService {
    private final KafkaTemplate<Integer, OrderDTO> kafkaTemplate;

    public KafkaOrderService(KafkaTemplate<Integer, OrderDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Order order) {
        Message<OrderDTO> message = MessageBuilder
                .withPayload(new OrderDTO(order.getId(), order.getStatus()))
                .setHeader(KafkaHeaders.TOPIC, "notificationsOrder")
                .build();
        kafkaTemplate.send(message);
    }
}
