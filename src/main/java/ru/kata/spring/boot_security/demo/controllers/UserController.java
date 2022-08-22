package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Controller
public class UserController {

    @GetMapping("/")
    public String startPage () {
        return "index";
    }

    @GetMapping("user")
    public String userPage () {
        return "/user";
    }

    @GetMapping("/admin")
    public String adminPage () {
        return "admin";
    }
}
