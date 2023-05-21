package com.course_project.airlines.services;

import com.course_project.airlines.models.User;
import com.course_project.airlines.models.enums.Role;
import com.course_project.airlines.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void createUser() {
        // TO DO password encoder test
        User user = new User();
        Set<Role> defaultUserRoles = new HashSet<>();
        defaultUserRoles.add(Role.ROLE_USER);
        userService.createUser(user);
        assertTrue(user.isActive());
        assertEquals(user.getRoles(), defaultUserRoles);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void list() {
        List<User> users = Arrays.asList(new User(), new User());
        Mockito.when(userRepository.findAll()).thenReturn(users);
        assertEquals(userService.list(), Arrays.asList(new User(), new User()));
    }

    @Test
    void banUser() {
        User user = new User();
        userService.createUser(user);
        user.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        userService.banUser(1L);
        assertFalse(user.isActive());
        assertThrows(EntityNotFoundException.class, () -> userService.banUser(0L));
        Mockito.verify(userRepository, Mockito.times(2)).save(user);
    }

    @Test
    void changeUserRoles() {
        User user = new User();
        userService.createUser(user);
        userService.changeUserRoles(user, Map.of("ROLE_USER", "ROLE_ADMIN"));
        Set<Role> adminUserRoles = new HashSet<>();
        adminUserRoles.add(Role.ROLE_ADMIN);
        assertEquals(user.getRoles(), adminUserRoles);
        Mockito.verify(userRepository, Mockito.times(2)).save(user);
    }
}