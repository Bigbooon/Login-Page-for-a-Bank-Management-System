package com.bank.bank_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        // This will render src/main/resources/templates/home.html
        return "home";
    }
}

