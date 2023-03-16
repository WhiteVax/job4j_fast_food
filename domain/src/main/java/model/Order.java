package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Order {
    private int id;
    private Status status;
    private double price;
    private List<Dish> dishes = new ArrayList<>();
    private String description;
}
