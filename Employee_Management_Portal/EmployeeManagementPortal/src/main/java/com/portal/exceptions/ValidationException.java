package com.portal.exceptions;

/**
 * This is a class to handle Illegal argument exceptions.
 */
public class ValidationException extends RuntimeException {
    /**.
     * parameterized constructor
     * @param message message for illegal argument exception
     */
    public ValidationException(final String message) {
        super(message);
    }
}
