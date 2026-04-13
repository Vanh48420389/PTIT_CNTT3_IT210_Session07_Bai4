package org.example.it210_session07.Bai1.controller;

import org.example.it210_session07.Bai1.model.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("bai1RestaurantController")
@RequestMapping("/bai1/merchant")
public class RestaurantController {

    @GetMapping("/profile")
    public String showProfileForm(Model model) {
        model.addAttribute("profile", new RestaurantProfile());
        return "Bai1/profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("profile") RestaurantProfile profile, Model model) {
        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Mở cửa: " + profile.isActive());

        model.addAttribute("successMessage", "Cập nhật thông tin thành công!");
        return "Bai1/profile";
    }
}