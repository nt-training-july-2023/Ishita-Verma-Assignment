package com.portal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.LoginOutDTO;

/**
 * The main class for the Employee Management Portal application.
 */
@SpringBootApplication
public class EmployeeManagementPortalApplication {

    /**
     * The main method to start the Employee Management Portal application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementPortalApplication.class, args);
    }

    /**
     * Provides a ModelMapper instance.
     *
     * @return An instance of ModelMapper for mapping between DTOs and entities.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Provides an instance of ApiResponseDTO for handling API responses.
     *
     * @return An instance of ApiResponseDTO.
     */
    @Bean
    public ApiResponseDTO apiResponseDTO() {
        return new ApiResponseDTO();
    }

    /**
     * Provides an instance of LoginResponseDTO for handling login responses.
     *
     * @return An instance of LoginResponseDTO.
     */
    @Bean
    public LoginOutDTO loginResponseDTO() {
        return new LoginOutDTO();
    }
}
