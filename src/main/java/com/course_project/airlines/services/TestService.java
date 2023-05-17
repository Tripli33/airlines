package com.course_project.airlines.services;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import com.course_project.airlines.repositories.FlightRepository;
import com.course_project.airlines.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;

@Service
@RequiredArgsConstructor
public class TestService {
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;

    public void orderFlight(Long id, Principal principal){
        Flight flight = flightRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Flight not found with id " + id));
        flight.setUser(userRepository.findByEmail(principal.getName()));
        flight.setOrderStatus(true);
        flightRepository.save(flight);
    }

    public void cancelFlight(Long id){
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with id " + id));
        flight.setUser(null);
        flight.setOrderStatus(false);
        flightRepository.save(flight);
    }
}
