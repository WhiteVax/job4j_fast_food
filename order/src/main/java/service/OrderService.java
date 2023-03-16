package service;

import model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);

    List<Order> findAll();

    Order findById(int id);

    void deleteById(int id);

    void updateOrder(Order order);
}
