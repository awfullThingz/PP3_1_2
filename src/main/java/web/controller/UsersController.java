package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller

public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "users/showAllUsers";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "users/show";
    }

    @GetMapping("/users/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        return "/users/new";


    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "users/edit";
    }

    @PatchMapping("/users/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "users/edit";

        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
