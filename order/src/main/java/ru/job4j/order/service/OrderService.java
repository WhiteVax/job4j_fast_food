package ru.job4j.order.service;

import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void saveOrder(Order order);

    List<Order> findAll();

    Optional<Order> findById(int id);
    boolean deleteById(int id);
    boolean updateOrder(Order order);
}
