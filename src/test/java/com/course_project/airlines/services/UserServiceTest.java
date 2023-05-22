package com.course_project.airlines.services;

import com.course_project.airlines.models.User;
import com.course_project.airlines.models.enums.Role;
import com.course_project.airlines.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private Principal principal;
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
    void getUserByPrincipal() {
        User mockUser = new User();
        Mockito.when(principal.getName()).thenReturn("mockEmail");
        Mockito.when(userRepository.findByEmail("mockEmail")).thenReturn(mockUser);
        assertEquals(userService.getUserByPrincipal(principal), new User());
        assertEquals(userService.getUserByPrincipal(null), new User());
    }

    @Test
    void list() {
        List<User> mockUsers = Arrays.asList(new User(), new User());
        Mockito.when(userRepository.findAll()).thenReturn(mockUsers);
        assertEquals(userService.list(), Arrays.asList(new User(), new User()));
    }

    @Test
    void banUser() {
        User mockUser = new User();
        userService.createUser(mockUser);
        mockUser.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
        userService.banUser(1L);
        assertFalse(mockUser.isActive());
        assertThrows(EntityNotFoundException.class, () -> userService.banUser(0L));
        Mockito.verify(userRepository, Mockito.times(2)).save(mockUser);
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