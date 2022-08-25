package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.security.UserDetailsImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserController(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/login")
//    public String loginPage() {
//        return "/login";
//    }

    @GetMapping("/user")
    public String userPage (@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        model.addAttribute("user", userDetails);
        userDetails.showUser();
        return "/user/user";
    }
    @GetMapping("/new")
    public String registrationUser(Model model) {
        model.addAttribute("newUser", new User());
        return "/newUser";
    }
    @PostMapping("/new")
    public String performRegistration(@ModelAttribute("newUser") User newUser) {
        newUser.setRoles(Set.of(roleRepository.findById(2).get()));
        userService.saveUser(newUser);
        System.out.println(newUser);
        return "redirect:/login";
    }

    @GetMapping("/logaut")
    public String logaut() {
        return "logaut";
    }
}
