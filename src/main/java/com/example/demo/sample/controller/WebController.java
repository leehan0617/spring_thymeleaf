package com.example.demo.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello World");
        return "home";
    }

}
