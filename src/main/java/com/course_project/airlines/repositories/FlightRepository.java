package com.course_project.airlines.repositories;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findFlightByFlightFromAndFlightToAndDepartDateAndReturnDateAndTypeTravelerAndOrderStatus(String flightFrom, String flightTo, String departDate, String returnDate, String typeTraveler, boolean orderStatus);

    List<Flight> findFlightsByUser(User user);
}
