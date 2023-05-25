package com.course_project.airlines.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller advice to provide global attributes and behavior for all controllers
 */
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalAdviceController {

    /**
     * Method for retrieving the username of the currently authenticated user for use in the user profile
     *
     * @param currentUser - UserDetails object representing the currently authenticated user
     * @return - the username of the authenticated user, or null if not authenticated
     */
    @ModelAttribute("userName")
    public String getUserProfile(@AuthenticationPrincipal UserDetails currentUser) {
        if (
                SecurityContextHolder.getContext().getAuthentication() != null &&
                        SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                        !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)

        ) {
            return currentUser.getUsername();
        } else {
            return null;
        }
    }
}
