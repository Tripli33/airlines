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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    private final FlightService flightService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        return "admin";
    }

    @PostMapping("/admin")
    public String userBan(@RequestParam("userId") Long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/admin/edit")
    public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return "redirect:/admin";
    }

    @GetMapping("/admin/add-flight")
    public String addFlight() {
        return "add-flight";
    }

    @PostMapping("/admin/add-flight")
    public String addFlight(Flight flight) {
        flightService.createFlight(flight);
        return "redirect:/admin/add-flight";
    }

    @PostMapping("/admin/cancel")
    public String cancelUserFlight(@RequestParam("flightId") Long id){
        flightService.cancelFlight(id);
        return "redirect:/";
    }

    @PostMapping("/admin/delete")
    public String deleteFlight(@RequestParam("flightId") Long id){
        flightService.deleteFlight(id);
        return "redirect:/";
    }
}
