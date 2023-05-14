package com.course_project.airlines.controllers;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class FlightController {
    private final FlightService flightService;
    @GetMapping("/")
    public String welcome(Model model, Principal principal){
        model.addAttribute("flights", flightService.showFlights());
        model.addAttribute("user", flightService.getUserByPrincipal(principal));
        return "welcome";
    }
    @GetMapping("/personal")
    public String personal(Model model, Principal principal){
        model.addAttribute("flights", flightService.getUserFlights(principal));
        return "personal";
    }
    @GetMapping("/order")
    public String order() {
        return "order";
    }


    @PostMapping("/order")
    public String orderFlight(Flight flight, Principal principal) {
        flightService.orderFlight(principal, flight.getFlightFrom(), flight.getFlightTo(), flight.getDepartDate(), flight.getReturnDate(), flight.getTypeTraveler());
        return "redirect:/personal";
    }

}
