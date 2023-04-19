package com.course_project.airlines.controllers;

import com.course_project.airlines.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
    private final FlightService flightService;
    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("flights", flightService.showFlights());
        return "welcome";
    }
}
