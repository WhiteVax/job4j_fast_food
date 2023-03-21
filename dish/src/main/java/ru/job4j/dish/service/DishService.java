package ru.job4j.dish.service;

import ru.job4j.domain.model.Dish;

import java.util.List;

public interface DishService {
    Dish createDish(Dish dish);
    boolean deleteDish(int id);
    boolean updateDish(Dish dish);
    List<Dish> findAll();
    Dish findById(int id);
    List<Dish> findByName(String name);
}
