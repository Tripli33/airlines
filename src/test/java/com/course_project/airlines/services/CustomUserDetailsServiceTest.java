package com.course_project.airlines.services;

import com.course_project.airlines.models.User;
import com.course_project.airlines.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CustomUserDetailsServiceTest {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void loadUserByUsername() {
        String mockEmail = "mock@example.com";
        User mockUser = new User();
        mockUser.setEmail(mockEmail);
        mockUser.setPassword("password");
        Mockito.when(userRepository.findByEmail(mockEmail)).thenReturn(mockUser);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(mockEmail);
        assertEquals(mockEmail, userDetails.getUsername());
        // TO DO method exception case
//        String mockEmailToo = "exception@example.com";
//        Mockito.when(userRepository.findByEmail(mockEmailToo)).thenReturn(null);
//        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername(mockEmailToo));
    }
}