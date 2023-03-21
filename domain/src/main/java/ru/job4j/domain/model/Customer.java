package ru.job4j.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Card card;
}
