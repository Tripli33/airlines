package com.course_project.airlines.repositories;

import com.course_project.airlines.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and managing User entities in the database
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Method for getting a user entity from the table "user"
     *
     * @param email - email address of the user
     * @return - user entity
     */
    User findByEmail(String email);
}
