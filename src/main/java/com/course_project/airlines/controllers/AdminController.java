package com.course_project.airlines.controllers;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import com.course_project.airlines.models.enums.Role;
import com.course_project.airlines.services.FlightService;
import com.course_project.airlines.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

/**
 * Controller to handle admin related requests
 * Requires ROLE_ADMIN authority for access
 */
@RequiredArgsConstructor
@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    private final FlightService flightService;

    /**
     * Handles the GET request for the admin page
     *
     * @param model - model object for adding attributes and rendering views
     * @return - name of the view template to be rendered
     */
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        return "admin";
    }

    /**
     * Handles the POST request for banning a user
     *
     * @param id - id of the user to be banned
     * @return - redirect to the admin page after banning the user
     */
    @PostMapping("/admin")
    public String userBan(@RequestParam("userId") Long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }

    /**
     * Handles the GET request for editing a user in the admin panel.
     *
     * @param user  - user entity to be edited
     * @param model - model object for adding attributes and rendering views
     * @return - name of the view template to be rendered for editing the user
     */
    @GetMapping("/admin/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    /**
     * Handles the POST request for editing a user's roles in the admin panel
     *
     * @param user - user entity to be edited
     * @param form - map containing the updated roles for the user from the view
     * @return - redirect to the admin page after editing the user's roles
     */

    @PostMapping("/admin/edit")
    public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return "redirect:/admin";
    }

    /**
     * Handles the GET request for adding a new flight in the admin panel
     *
     * @return - name of the view template to be rendered for adding a flight
     */
    @GetMapping("/admin/add-flight")
    public String addFlight() {
        return "add-flight";
    }

    /**
     * Handles the POST request for adding a new flight in the admin panel.
     *
     * @param flight - flight entity to be added
     * @param bindingResult - binding result object for validating flight input
     * @param model - model object for adding attributes and rendering views
     * @return - redirects to the add-flight page if the flight is successfully added or in case of validation errors
     * return the name of the view template
     */
    @PostMapping("/admin/add-flight")
    public String addFlight(@Valid Flight flight, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "add-flight";
        }
        flightService.createFlight(flight);
        return "redirect:/admin/add-flight";
    }

    /**
     * Handles the POST request for canceling a user's flight by the admin
     *
     * @param id - id of the flight to be canceled
     * @return - redirect to the home page after canceling the flight
     */
    @PostMapping("/admin/cancel")
    public String cancelUserFlight(@RequestParam("flightId") Long id) {
        flightService.cancelFlight(id);
        return "redirect:/";
    }

    /**
     * Handles the POST request for deleting a flight by the admin
     *
     * @param id - id of the flight to be deleted
     * @return - the redirect to the home page after deleting the flight
     */
    @PostMapping("/admin/delete")
    public String deleteFlight(@RequestParam("flightId") Long id) {
        flightService.deleteFlight(id);
        return "redirect:/";
    }
}
