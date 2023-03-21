package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.admin.service.APIDishService;

@Controller
@RequestMapping("/admin/dishes")
@AllArgsConstructor
public class APIDishController {
    private final APIDishService dishService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dish/all";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id")int id, Model model) {
        model.addAttribute("dish", dishService.findById(id));
        return "dish/one";
    }

    @GetMapping("/update/{id}")
    public String updateDish(@PathVariable("id")int id, Model model) {
        model.addAttribute("dish", dishService.findById(id));
        return "dish/one";
    }

    /**
     * Дописать в админку другую часть с фронтом delete, update, findByName
     *  @GetMapping("/getByName")
     *     public String findByName(@RequestParam ("name") String name, Model model) {
     *         model.addAttribute("dishes", dishService.findByName(name));
     *         return "dish/all";
     *     }
     */
}
