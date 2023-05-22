package com.course_project.airlines.services;

import com.course_project.airlines.models.Flight;
import com.course_project.airlines.models.User;
import com.course_project.airlines.repositories.FlightRepository;
import com.course_project.airlines.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightServiceTest {
    @Autowired
    private FlightService flightService;
    @MockBean
    private Principal principal;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private FlightRepository flightRepository;

    @Test
    void list() {
        List<Flight> mockFlights = Arrays.asList(new Flight(), new Flight());
        Mockito.when(flightRepository.findAll()).thenReturn(mockFlights);
        assertEquals(flightService.list(), Arrays.asList(new Flight(), new Flight()));
    }

    @Test
    void getUserFlights() {
        List<Flight> mockFlights = Arrays.asList(new Flight(), new Flight());
        Mockito.when(principal.getName()).thenReturn("mockEmail");
        Mockito.when(userRepository.findByEmail("mockEmail")).thenReturn(new User());
        Mockito.when(flightRepository.findFlightsByUser(new User())).thenReturn(mockFlights);
        assertEquals(flightService.getUserFlights(principal), Arrays.asList(new Flight(), new Flight()));
    }

    @Test
    void createFlight() {
        Flight flight = new Flight();
        flightService.createFlight(flight);
        assertFalse(flight.isOrderStatus());
        Mockito.verify(flightRepository, Mockito.times(1)).save(flight);
    }

    @Test
    void orderFlight() {
        Flight mockFlight = new Flight();
        User mockUser = new User();
        Mockito.when(flightRepository.findById(1L)).thenReturn(Optional.of(mockFlight));
        Mockito.when(principal.getName()).thenReturn("mockEmail");
        Mockito.when(userRepository.findByEmail("mockEmail")).thenReturn(mockUser);
        flightService.orderFlight(1L, principal);
        assertEquals(mockFlight.getUser(), new User());
        assertTrue(mockFlight.isOrderStatus());
        assertThrows(EntityNotFoundException.class, () -> flightService.orderFlight(0L, principal));
        Mockito.verify(flightRepository, Mockito.times(1)).save(mockFlight);
    }

    @Test
    void cancelFlight() {
        Flight mockFlight = new Flight();
        Mockito.when(flightRepository.findById(1L)).thenReturn(Optional.of(mockFlight));
        flightService.cancelFlight(1L);
        assertFalse(mockFlight.isOrderStatus());
        assertNull(mockFlight.getUser());
        assertThrows(EntityNotFoundException.class, () -> flightService.cancelFlight(0L));
        Mockito.verify(flightRepository, Mockito.times(1)).save(mockFlight);
    }

    @Test
    void deleteFlight() {
        Flight mockFlight = new Flight();
        Mockito.when(flightRepository.findById(1L)).thenReturn(Optional.of(mockFlight));
        flightService.deleteFlight(1L);
        Mockito.verify(flightRepository, Mockito.times(1)).delete(mockFlight);
    }
}