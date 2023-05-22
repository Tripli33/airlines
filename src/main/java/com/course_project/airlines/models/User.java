package com.course_project.airlines.models;

import com.course_project.airlines.models.enums.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "user")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Email required")
    @Column(name = "email", unique = true)
    private String email;

    @Pattern(regexp = "\\+\\d{3}\\s?\\(?(\\d{2})\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2}",
            message = "Incorrect phone number")
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @NotBlank(message = "Username required")
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private boolean active;

    @Size(min = 4, message = "Password must contain at least 4 characters")
    @Column(name = "password", length = 1000)
    private String password;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Flight> products = new ArrayList<>();
    private LocalDateTime dateOfCreated;

    /**
     * Method for initializing the creation date of the user entity
     */
    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    /**
     * Method for determining if the user has the role of an admin
     *
     * @return - true if the user has the admin role, false otherwise
     */
    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }

    /**
     * Method for retrieving the authorities (roles) associated with the user
     *
     * @return - collection of GrantedAuthority objects representing the roles of the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    /**
     * Method for retrieving the username (email) of the user
     *
     * @return - email address associated with the user
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Method for checking if the user account has expired
     *
     * @return - true if the user account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Method for checking if the user account is locked
     *
     * @return - true if the user account is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Method for checking if the user credentials (password) are expired
     *
     * @return - true if the user credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Method for checking if the user account is enabled
     *
     * @return - true if the user account is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return active;
    }
}