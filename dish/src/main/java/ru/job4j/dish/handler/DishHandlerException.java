package ru.job4j.dish.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

@ControllerAdvice
@AllArgsConstructor
@Slf4j
public class DishHandlerException {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = {NoSuchElementException.class})
    public void handlerNoSuchElementException(Exception e, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setContentType("application/json");
        resp.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {{
            put("message", "Not found this dish.");
            put("details", e.getMessage());
        }}));
        log.error(e.getMessage());
    }
}
