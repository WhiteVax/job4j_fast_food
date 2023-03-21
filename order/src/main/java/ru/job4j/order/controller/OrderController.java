package ru.job4j.order.controller;

import ru.job4j.domain.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<>(
                order,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        orderService.updateOrder(order);
        return new ResponseEntity<>(
                order,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id) {
        orderService.deleteById(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }
}
