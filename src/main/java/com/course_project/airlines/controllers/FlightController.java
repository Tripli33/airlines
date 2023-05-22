package com.course_project.airlines.controllers;

import com.course_project.airlines.services.FlightService;
import com.course_project.airlines.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class FlightController {
    private final FlightService flightService;
    private final UserService userService;

    /**
     * Handles the GET request for the home page
     *
     * @param model - model object for adding attributes and rendering views
     * @param principal - the currently logged-in user
     * @return - name of the view template to be rendered
     */
    @GetMapping("/")
    public String welcome(Model model, Principal principal) {
        model.addAttribute("flights", flightService.list());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "welcome";
    }

    /**
     * Handles the POST request for ordering a flight
     *
     * @param id - id of the flight to be ordered
     * @param principal - currently logged-in user
     * @return - redirect to the personal page after ordering the flight
     */
    @PostMapping("/")
    public String orderFlight(@RequestParam("flightId") Long id, Principal principal) {
        flightService.orderFlight(id, principal);
        return "redirect:/personal";
    }

    /**
     * Handles the GET request for the personal page
     *
     * @param model - model object for adding attributes and rendering views
     * @param principal - currently logged-in user
     * @return - name of the view template to be rendered
     */
    @GetMapping("/personal")
    public String personal(Model model, Principal principal) {
        model.addAttribute("flights", flightService.getUserFlights(principal));
        return "personal";
    }

    /**
     * Handles the POST request for canceling a flight
     *
     * @param id - id of the flight to be canceled
     * @return - redirect to the personal page after canceling the flight
     */
    @PostMapping("/personal")
    public String cancelFlight(@RequestParam("flightId") Long id) {
        flightService.cancelFlight(id);
        return "redirect:/personal";
    }
}
