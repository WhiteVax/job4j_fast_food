package ru.job4j.order.service;

import ru.job4j.domain.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);

    List<Order> findAll();

    Order findById(int id);

    void deleteById(int id);

    void updateOrder(Order order);
}
