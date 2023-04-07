package ru.job4j.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.job4j.domain.model.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private int id;
    private Status status;

    @Override
    public String toString() {
        return "OrderDTO{"
                + "id=" + id
                + ", status=" + status
                + '}';
    }
}
