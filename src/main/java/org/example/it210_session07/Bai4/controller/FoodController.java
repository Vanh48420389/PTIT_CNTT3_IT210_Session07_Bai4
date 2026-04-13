package org.example.it210_session07.Bai4.controller;

import org.example.it210_session07.Bai4.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller("bai4FoodController")
@RequestMapping("/bai4/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();
    private static int idCounter = 1;

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("food", new Food());
        return "Bai4/food-add";
    }

    @PostMapping("/add")
    public String saveFood(@ModelAttribute("food") Food food,
                           @RequestParam("image") MultipartFile file,
                           RedirectAttributes redirectAttributes,
                           Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng đính kèm hình ảnh!");
            return "Bai4/food-add";
        }

        try {
            File uploadDir = new File("C:/RikkeiFood_Temp/");
            if (!uploadDir.exists()) uploadDir.mkdirs();

            String originalName = file.getOriginalFilename();
            String uniqueFileName = UUID.randomUUID().toString() + "_" + originalName;

            File saveFile = new File(uploadDir, uniqueFileName);
            file.transferTo(saveFile);

            food.setId(idCounter++);
            food.setImageName(uniqueFileName);
            food.setPhysicalPath(saveFile.getAbsolutePath());
            foodList.add(food);

            redirectAttributes.addFlashAttribute("successMessage", "Thêm món thành công (File lưu: " + uniqueFileName + ")");

            return "redirect:/bai4/food/detail?id=" + food.getId();

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi lưu file!");
            return "Bai4/food-add";
        }
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        Food foundFood = foodList.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("foodDetail", foundFood);
        return "Bai4/food-detail";
    }
}
