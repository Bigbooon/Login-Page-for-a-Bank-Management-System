package com.bank.bank_management.controller;

import com.bank.bank_management.model.User;
import com.bank.bank_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        System.out.println("GET /register invoked");
        model.addAttribute("user", new User());
        return "register";  // This should map to register.html
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/login?registerSuccess";
    }
}

