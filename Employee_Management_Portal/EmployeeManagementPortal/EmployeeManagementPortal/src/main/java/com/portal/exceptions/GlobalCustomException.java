package com.portal.exceptions;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.portal.DTO.ApiResponseDTO;
/**
 * Custom Exception.
 */
@RestControllerAdvice
public class GlobalCustomException extends RuntimeException {
    /**
     * @param exception
     * @return ResponseDTO
     */
     @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ApiResponseDTO handleResourceNotFoundException(
            final ResourceNotFoundException exception) {
        String message = exception.getMessage();
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage(message);
        return response;
    }
    /**
     * WrongCredentialsException.
     * @param exception Exception
     * @return ResponseDTO
     */
     @ExceptionHandler(WrongCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ApiResponseDTO handleWrongCredentialException(
            final WrongCredentialsException exception) {
        String message = exception.getMessage();
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage(message);
        return response;
    }
    /**
     * IllegalArgumentException.
     * @param exception Exception
     * @return ResponseDTO
     */
     @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ApiResponseDTO handleIllegalArgumentException(
            final ValidationException exception) {
        String message = exception.getMessage();
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage(message);
        return response;
    }
    /**
     * ResouceAlreadyExistsException.
     * @param exception Exception
     * @return ResponseDTO
     */
    @ExceptionHandler(DuplicateEntryException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public final ApiResponseDTO handleResourceAlreadyExistsException(
            final DuplicateEntryException exception) {
        String message = exception.getMessage();
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage(message);
        return response;
    }
     /**
     * Handles validation errors.
     * @param ex exception representing the validation error.
     * @return A ResponseEntity containing a map of field names.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Map<String, String> handleDtoValidation(
            final MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return resp;
    }
}
