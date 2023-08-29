package com.portal.exception;

/**
 * Custom exception class to handle resource not found scenarios.
 */
public class DuplicateEntryException extends RuntimeException {

    /**
     * Constructs a new DuplicateEntryException
     *  with the specified detail message.
     *
     * @param message The detail message.
     */
    public DuplicateEntryException(final String message) {
        super(message);
    }
}
