package com.course_project.airlines.services;

import com.course_project.airlines.models.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private List<Flight> flightList = new ArrayList<>();
    {
        flightList.add(new Flight("MIA", "MSP", "4.19.2023", "4.19.23", "Adult", false));
        flightList.add(new Flight("MNL", "MKE", "4.19.2023", "4.19.23", "Adult", false));
    }
    public List<Flight> showFlights(){
        return flightList;
    }
}
