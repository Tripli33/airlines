package com.course_project.airlines.repositories;

import com.course_project.airlines.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Method for getting a user entity from the table "user"
     *
     * @param email - email address of the user
     * @return - user entity
     */
    User findByEmail(String email);
}
