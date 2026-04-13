package org.example.it210_session07.Bai3.controller;

import org.example.it210_session07.Bai3.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("bai3FoodController")
@RequestMapping("/bai3/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("food", new Food());
        return "Bai3/food-add";
    }

    @PostMapping("/add")
    public String saveFood(@ModelAttribute("food") Food food,
                           @RequestParam("image") MultipartFile file,
                           Model model) {

        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá tiền không được âm");
            return "Bai3/food-add";
        }

        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng đính kèm hình ảnh");
            return "Bai3/food-add";
        }

        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.toLowerCase().matches(".*\\.(jpg|png|jpeg)$")) {
            model.addAttribute("error", "Chỉ chấp nhận file ảnh (.jpg, .png, .jpeg)");
            return "Bai3/food-add";
        }

        try {
            File uploadDir = new File("C:/RikkeiFood_Temp/");
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            File saveFile = new File(uploadDir, fileName);
            file.transferTo(saveFile);

            food.setImageName(fileName);
            foodList.add(food);

            System.out.println("--- ĐÃ THÊM MÓN ĂN MỚI ---");
            System.out.println("Tên món: " + food.getName() + " | Giá: " + food.getPrice());
            System.out.println("Danh mục: " + food.getCategory());
            System.out.println("File ảnh đã lưu: " + saveFile.getAbsolutePath());
            System.out.println("=> Tổng số món hiện tại: " + foodList.size());

            model.addAttribute("successMessage", "Thêm món thành công!");

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi lưu file: " + e.getMessage());
        }

        return "Bai3/food-add";
    }
}