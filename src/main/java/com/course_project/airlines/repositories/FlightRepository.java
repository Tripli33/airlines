package com.course_project.airlines.repositories;

import com.course_project.airlines.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
