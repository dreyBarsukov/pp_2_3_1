package com.web.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("users", userService.findAll());
            return "index";
        } else {
            model.addAttribute("user", userService.findOne(id));
            return "show";
        }
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PatchMapping()
    public String update(@RequestParam(value = "id", required = false) Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
