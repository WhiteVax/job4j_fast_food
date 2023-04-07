package ru.job4j.order.controller;

import ru.job4j.domain.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.service.OrderService;
import ru.job4j.order.service.SimpleOrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final SimpleOrderService orderService;

    public OrderController(SimpleOrderService simpleOrderService) {
        this.orderService = simpleOrderService;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") int id) {
        var order = orderService.findById(id);
        return new ResponseEntity<>(
                order.orElse(new Order()),
                order.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
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
        return new ResponseEntity<>(
                order,
                orderService.updateOrder(order) ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id) {
        return new ResponseEntity<>(
                orderService.deleteById(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
