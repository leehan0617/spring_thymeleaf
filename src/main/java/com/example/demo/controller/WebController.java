package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }

    @GetMapping("/list")
    public String list() {
        return "list";
    }
}
