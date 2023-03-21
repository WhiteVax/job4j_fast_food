package ru.job4j.order.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class OrderHandlerException {
    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = {NoSuchElementException.class})
    public void handlerExceptionNoSuchElement(Exception e, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setContentType("application/json");
        resp.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() { {
            put("message", "Not found this order.");
            put("details", e.getMessage());
        }}));
        log.error(e.getMessage());
    }
}
