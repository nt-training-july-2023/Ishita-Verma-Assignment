package com.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class to handle resource not found scenarios.
 */
@ResponseStatus(HttpStatus.FOUND)
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
