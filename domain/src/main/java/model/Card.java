package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Card {
    private int id;
    private Long number;
    private double discount = 1.0;
    private LocalDateTime expirationDate;
    private boolean active;
}
