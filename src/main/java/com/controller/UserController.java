package com.controller;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @GetMapping
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
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new";
        } else {
            userService.save(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PatchMapping
    public String update(@RequestParam(value = "id", required = false) Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
