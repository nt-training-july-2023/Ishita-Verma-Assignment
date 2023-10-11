package com.portal.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ResponseDTO;

class GlobalCustomExceptionTest {

    @Mock
    private BindingResult bindingResult;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;
    
    @InjectMocks
    private GlobalCustomException exceptionHandler;

	@Test
    void testHandleResourceNotFoundException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        ApiResponseDTO response = exceptionHandler.handleResourceNotFoundException(exception);
        assertEquals("Resource not found", response.getMessage());
	}

    @Test
    void testHandleWrongCredentialException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        WrongCredentialsException exception = new WrongCredentialsException("Wrong credentials");
        ApiResponseDTO response = exceptionHandler.handleWrongCredentialException(exception);
        assertEquals("Wrong credentials", response.getMessage());

    }

    @Test
    void testHandleIllegalArgumentException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        ValidationException exception = new ValidationException("Invalid argument");
        ApiResponseDTO response = exceptionHandler.handleIllegalArgumentException(exception);
        assertEquals("Invalid argument", response.getMessage());

    }

    @Test
    void testHandleResourceAlreadyExistsException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        DuplicateEntryException exception = new DuplicateEntryException("Resource already exists");
        ApiResponseDTO response = exceptionHandler.handleResourceAlreadyExistsException(exception);
        assertEquals("Resource already exists", response.getMessage());

    }
    @Test
    void testHandleDtoValidation() {
        when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);
        FieldError fieldError = mock(FieldError.class);
        when(fieldError.getField()).thenReturn("fieldName");
        when(fieldError.getDefaultMessage()).thenReturn("Validation error message");
        when(bindingResult.getAllErrors()).thenReturn(List.of(fieldError));
        Map<String, String> response = exceptionHandler.handleDtoValidation(methodArgumentNotValidException);
        assertEquals("Validation error message", response.get("fieldName"));
    }
}
