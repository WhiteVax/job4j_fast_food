package service;

import model.Dish;

import java.util.List;

public interface DishService {
    void addDish(Dish dish);
    void deleteDish(int id);
    List<Dish> findAll();
}
