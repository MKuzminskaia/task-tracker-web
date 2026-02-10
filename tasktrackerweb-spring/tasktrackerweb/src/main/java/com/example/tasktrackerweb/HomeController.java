package com.example.tasktrackerweb;   // <-- ВАЖНО: подставь ТОТ пакет, который у тебя в Application

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}