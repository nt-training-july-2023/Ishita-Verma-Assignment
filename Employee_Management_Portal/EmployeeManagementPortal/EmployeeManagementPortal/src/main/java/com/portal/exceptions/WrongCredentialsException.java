package com.portal.exceptions;

/**
 * Custom exception class to handle wrong username password.
 */
public class WrongCredentialsException extends RuntimeException {
    /**
     * Constructs a new DuplicateEntryException
     *  with the specified detail message.
     *
     * @param message The detail message.
     */
    public WrongCredentialsException(final String message) {
        super(message);
    }
}