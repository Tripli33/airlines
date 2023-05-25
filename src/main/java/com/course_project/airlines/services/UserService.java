package com.course_project.airlines.services;

import com.course_project.airlines.models.User;
import com.course_project.airlines.models.enums.Role;
import com.course_project.airlines.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class that provides methods for managing users
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Method for creating a new user entity in the table "user"
     *
     * @param user - user entity from the view
     */
    public void createUser(User user) {
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * Method for getting all user entities from the table "user"
     *
     * @return - all users
     */
    public List<User> list() {
        return userRepository.findAll();
    }

    /**
     * Method for getting a user entity from the table "user"
     *
     * @param principal - the currently logged-in user
     * @return - currently logged-in user entity
     */
    public User getUserByPrincipal(Principal principal) {
        // TODO refactor
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    /**
     * Method for changing the activity status of the user entity to the opposite one (authorize -> can't authorize, etc.)
     *
     * @param id - id of the current user
     */
    public void banUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    /**
     * Method for changing the status of the role of the user entity to the opposite one (admin -> user, etc.)
     *
     * @param user - user entity
     * @param form - set of roles from the view
     */
    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String val : form.values()) {
            if (roles.contains(val)) {
                user.getRoles().add(Role.valueOf(val));
                break;
            }
        }
        userRepository.save(user);
    }
}
