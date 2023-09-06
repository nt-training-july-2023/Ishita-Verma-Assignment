package com.portal.exception;
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
    public WrongCredentialsException(String message) {
        super();
    }
}
