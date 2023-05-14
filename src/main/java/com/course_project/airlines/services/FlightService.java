package com.course_project.airlines.services;

import com.course_project.airlines.controllers.FlightController;
import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import com.course_project.airlines.models.enums.Role;
import com.course_project.airlines.repositories.FlightRepository;
import com.course_project.airlines.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;

    public List<Flight> showFlights(){
        return flightRepository.findAll();
    }

    public void orderFlight(Principal principal, String flightFrom, String flightTo, String departDate, String returnDate, String typeTraveler){
        Flight flight = flightRepository.findFlightByFlightFromAndFlightToAndDepartDateAndReturnDateAndTypeTraveler(flightFrom, flightTo, departDate, returnDate,typeTraveler);
        flight.setOrderStatus(true);
        flight.setUser(getUserByPrincipal(principal));
        flightRepository.save(flight);
    }

    public List<Flight> getUserFlights(Principal principal){
        return flightRepository.findFlightsByUser(userRepository.findByEmail(principal.getName()));
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void createFlight(Flight flight) {
        flight.setOrderStatus(false);
        flightRepository.save(flight);
    }
}
