package com.course_project.airlines.repositories;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    //TODO add find by order status true
    Flight findFlightByFlightFromAndFlightToAndDepartDateAndReturnDateAndTypeTraveler(String flightFrom, String flightTo, String departDate, String returnDate, String typeTraveler);
    List<Flight> findFlightsByUser(User user);

}
