package com.course_project.airlines.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    /**
     * Method for retrieving the authority (role) associated with the user
     *
     * @return the name of the authority (role)
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
