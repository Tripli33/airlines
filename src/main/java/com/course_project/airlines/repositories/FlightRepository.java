package com.course_project.airlines.repositories;

import com.course_project.airlines.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findFlightByFlightFromAndFlightToAndDepartDateAndReturnDateAndTypeTraveler(String flightFrom, String flightTo, String departDate, String returnDate, String typeTraveler);
}
