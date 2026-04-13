package org.example.it210_session07.Bai2.controller;

import org.example.it210_session07.Bai2.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller("bai2DishController")
@RequestMapping("/bai2/merchant/dish")
public class DishController {

    @ModelAttribute("categories")
    public List<String> provideCategories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "Bai2/dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        Dish mockDish = new Dish();
        mockDish.setName("Trà sữa");
        mockDish.setCategory("Đồ uống");

        model.addAttribute("dish", mockDish);
        return "Bai2/dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage(Model model) {
        return "Bai2/dish-search";
    }
}