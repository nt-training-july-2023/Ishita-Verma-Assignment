package com.portal.exceptions;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.portal.DTO.ResponseDTO;

/**
 * Custom Exception.
 */
@RestControllerAdvice
public class GlobalCustomException {
    /**
     * ResourceNotFoundException.
     * @param ResourceNotFoundException resourceNotFoundException.
     * @return ResponseDTO
     */
     @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseDTO handleResourceNotFoundException(
            final ResourceNotFoundException exception) {
        String message = exception.getMessage();
        return new ResponseDTO(message, " ");
    }
    /**
     * WrongCredentialsException.
     * @param exception Exception
     * @return ResponseDTO
     */
     @ExceptionHandler(WrongCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseDTO handleWrongCredentialException(
            final WrongCredentialsException exception) {
        String message = exception.getMessage();
        return new ResponseDTO(message, "");
    }
    /**
     * IllegalArgumentException.
     * @param exception Exception
     * @return ResponseDTO
     */
     @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseDTO handleIllegalArgumentException(
            final ValidationException exception) {
        String message = exception.getMessage();
        return new ResponseDTO(message, "");
    }
    /**
     * ResouceAlreadyExistsException.
     * @param exception Exception
     * @return ResponseDTO
     */
    @ExceptionHandler(DuplicateEntryException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public final ResponseDTO handleResourceAlreadyExistsException(
            final DuplicateEntryException exception) {
        String message = exception.getMessage();
        return new ResponseDTO(message, "");
    }
     
     @ExceptionHandler(MethodArgumentNotValidException.class)
  // @ResponseStatus(HttpStatus.BAD_REQUEST)
   public final ResponseEntity<Map<String, String>> handleEmptyDataValidation(
           final MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
       return new ResponseEntity<Map<String, String>>(
               resp, HttpStatus.BAD_REQUEST);
   }
}
