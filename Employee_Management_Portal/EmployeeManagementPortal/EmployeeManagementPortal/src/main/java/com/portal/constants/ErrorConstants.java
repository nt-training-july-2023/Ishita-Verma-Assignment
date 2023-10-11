package com.portal.constants;
/**
 * Constants for error messages related to various operations.
 */
public final class ErrorConstants {
    /**
     * Error message for an invalid password.
     */
    public static final String INVALID_PASSWORD_MESSAGE
    = "Invalid Password";
    /**
     * Error message for a wrong name format.
     */
    public static final String WRONG_NAME = "Please provide a valid name.";
    /**
     * Error message for a wrong email format.
     */
    public static final String WRONG_EMAIL
    = "Please provide a valid email address.";
    /**
     * Error message for a wrong employee ID format.
     */
    public static final String WRONG_ID
    = "Please provide a valid employee ID.";
    /**
     * Error message for an email ID that already exists.
     */
    public static final String EMAIL_EXISTS = "Email id already exists";
    /**
     * Error message for an employee ID that already exists.
     */
    public static final String ID_EXISTS = "Employee id already exists";
    /**
     * Error message indicating that same name already exists.
     */
    public static final String NAME_EXISTS
    = "Project with this name already exists";
    /**
     * Error message for an invalid user.
     */
    public static final String INAVALID_USER = "Invalid user";
    /**
     * Error message for wrong login credentials.
     */
    public static final String WRONG_CREDENTIALS = "Wrong Credentials";
    /**
     * Error message indicating that an employee was not found.
     */
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    /**
     * Error message indicating that an employee is not assigned to any project.
     */
    public static final String EMPLOYEE_NOT_ASSIGNED
    = "Employee is not assigned to any project.";
    /**
     * Error message indicating that registration as
     * ADMIN is not allowed for this email.
     */
    public static final String INVALID_EMPLOYEE
    = "Registration as ADMIN is not allowed for this email.";
    /**
     * Error message indicating that a project with a specific ID was not found.
     */
    public static final String PROJECT_NOT_FOUND
    = "Project with this ID not found";
    /**
     * Error message indicating that a manager with a specific ID was not found.
     */
    public static final String MANAGER_NOT_FOUND
    = "Manager with this ID not found";
    /**
     * Error message indicating that skills are required.
     */
    public static final String SKILLS_REQUIRED = "Skills Required";
    /**
     * Constructor using superclass.
     */
    private ErrorConstants() {
    }
}
