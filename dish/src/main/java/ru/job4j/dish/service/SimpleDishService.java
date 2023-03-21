package ru.job4j.dish.service;

import ru.job4j.domain.model.Dish;
import ru.job4j.dish.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SimpleDishService implements DishService {
    private final DishRepository dishRepository;

    public SimpleDishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public boolean deleteDish(int id) {
        if (dishRepository.existsById(id)) {
            return false;
        }
        dishRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateDish(Dish dish) {
        if (dishRepository.existsById(dish.getId())) {
            return false;
        }
        dishRepository.update(dish.getName(), dish.getComposition(), dish.getPrice(), dish.getId());
        return true;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(int id) {
        return dishRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Not found this dish with id = %s.", id))
        );
    }

    @Override
    public List<Dish> findByName(String name) {
        return dishRepository.findByName(name);
    }
}
