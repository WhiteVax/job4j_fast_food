package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import ru.job4j.dish.service.DishService;

import java.util.Collections;
import java.util.List;

@Service
public class APIDishService implements DishService {

    @Value("${api-dish-url}")
    private String url;
    private final RestTemplate client;

    @Autowired
    public APIDishService(RestTemplate client) {
        this.client = client;
    }

    @Override
    public Dish createDish(Dish dish) {
        return client.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    @Override
    public boolean deleteDish(int id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public boolean updateDish(Dish dish) {
        return client.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public List<Dish> findAll() {
        return getList(String.format(
                "%s/", url
        ));
    }

    @Override
    public List<Dish> findByName(String name) {
        return getList(String.format(
                "%s/getByName?name=%s", url, name
        ));
    }

    private List<Dish> getList(String url) {
        List<Dish> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    @Override
    public Dish findById(int id) {
        return client.getForEntity(
                String.format("%s/id?id=%s", url, id),
                Dish.class
        ).getBody();
    }
}
