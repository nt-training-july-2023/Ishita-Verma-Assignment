package com.portal.validations;
import org.springframework.stereotype.Component;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.exception.WrongCredentialsException;

/**
 * This class provides validation methods for various data inputs.
 */
@Component
public class Validation {
    /**
     * Checks if the provided name is valid.
     * @param name The name to be validated.
     * @return true if the name is valid, false otherwise.
     */
    public final boolean checkName(final String name) {
        if (!name.isEmpty() && name.matches("^[A-Za-z ]+$")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the provided email is valid.
     * @param email The email to be validated.
     * @return true if the email is valid, false otherwise.
     */
    public final boolean checkEmail(final String email) {
        if (!email.isEmpty() && email.matches(".*@nucleusteq\\.com$")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the provided employee ID (empId) is valid.
     * @param empId The employee ID (empId) to be validated.
     * @return true if the employee ID (empId) is valid, false otherwise.
     */
    public final boolean checkempId(final String empId) {
        if (!empId.isEmpty() && empId.matches("N\\d{4}$")) {
            return true;
        }
        return false;
    }

    /**
     * Validates a user's registration information.
     * @param userDto The AdminDTO containing user registration details.
     * @return true if the user registration information is valid.
     * @throws WrongCredentialsException if any details are invalid.
     */
    public final boolean checkUser(final AdminDTO userDto) {
        if (!checkName(userDto.getName())) {
            throw new WrongCredentialsException(
                    "Please provide a valid name.");
        }
        if (!checkEmail(userDto.getEmail())) {
            throw new WrongCredentialsException(
                    "Please provide a valid email address.");
        }
        if (!checkempId(userDto.getEmpId())) {
            throw new WrongCredentialsException(
                    "Please provide a valid employee ID.");
        }
        return true;
    }

    /**
     * Validates a user's login credentials.
     * @param loginDto The LoginDTO containing login credentials.
     * @return true if the login credentials are valid.
     * @throws WrongCredentialsException if the provided email is invalid.
     */
    public final boolean checkLoginDto(final LoginDTO loginDto) {
        if (!checkName(loginDto.getEmail())) {
            throw new WrongCredentialsException(
                    "Please provide a valid email address.");
        }
        return true;
    }
}
