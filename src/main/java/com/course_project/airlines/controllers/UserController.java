package com.course_project.airlines.controllers;

import com.course_project.airlines.models.User;
import com.course_project.airlines.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Controller class for handling user-related operations such as login and registration
 */
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Handles the GET request for the login page
     *
     * @return - name of the login view template to be rendered
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles the GET request for the registration page
     *
     * @return - name of the registration view template to be rendered
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
     * Handles the POST request for user registration
     *
     * @param user - user entity containing the user data from the registration form
     * @param bindingResult - binding result object to capture any validation errors from the registration form
     * @param model - model object to add attributes for the view
     * @return - redirects to the login page if the user is successfully registered or in case of validation errors return
     * the name of the view template
     */
    @PostMapping("/registration")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
}
