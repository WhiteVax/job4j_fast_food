package ru.job4j.dish.repository;

import ru.job4j.domain.model.Dish;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish, Integer> {
        List<Dish> findByName(String name);
        void deleteById(int id);
        List<Dish> findAll();
        @Modifying
        @Query("UPDATE Dish d set d.name = :name,  d.composition = :composition, d.price = :price WHERE d.id = :id")
        void update(String name, String composition, double price, int id);
}
