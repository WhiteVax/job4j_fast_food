package ru.job4j.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.job4j.domain.dto.OrderDTO;
import ru.job4j.domain.model.Order;
import ru.job4j.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;

    private final KafkaOrderService kafkaTemplate;

    public SimpleOrderService(OrderRepository orderRepository, KafkaOrderService kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
        kafkaTemplate.send(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        if (!orderRepository.existsById(id)) {
            log.error(String.format("It is impossible to delete a non-existing order, with id = %s.", id));
            return false;
        }
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        if (!orderRepository.existsById(order.getId())) {
            log.error(String.format("It is impossible to delete a non-existing order, with id = %s.", order.getId()));
            return false;
        }
        orderRepository.update(order.getStatus().name(), order.getDescription(), order.getId());
        return true;
    }
}
