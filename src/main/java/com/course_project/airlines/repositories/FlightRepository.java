package com.course_project.airlines.repositories;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for accessing and managing Flight entities in the database
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
    /**
     * Method for getting all user flight entities from the table "flight"
     *
     * @param user - user entity
     * @return - all user flights
     */
    List<Flight> findFlightsByUser(User user);
}
