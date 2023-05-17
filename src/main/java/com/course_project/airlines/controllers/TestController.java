package com.course_project.airlines.controllers;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    @PostMapping("/")
    public String orderFlight(@RequestParam("flightId")Long id, Principal principal){
        testService.orderFlight(id, principal);
        return "redirect:/personal";
    }

    @PostMapping("/personal")
    public String unOrderFlight(@RequestParam("flightId")Long id){
        testService.cancelFlight(id);
        return "redirect:/personal";
    }
}
