package ru.job4j.dish.controller;

import ru.job4j.domain.model.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/api-dish")
public class DishRESTController {

    private final DishService dishService;

    public DishRESTController(DishService simpleDishService) {
        this.dishService = simpleDishService;
    }

    @GetMapping
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish save(@RequestBody Dish dish) {
        return dishService.createDish(dish);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Dish dish) {
        boolean status = dishService.updateDish(dish);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        boolean status = dishService.deleteDish(id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("/id")
    public Dish findById(@RequestParam int id) {
        return dishService.findById(id);
    }

    @GetMapping("/getByName")
    public List<Dish> getByName(@RequestParam String name) {
        return dishService.findByName(name);
    }
}
