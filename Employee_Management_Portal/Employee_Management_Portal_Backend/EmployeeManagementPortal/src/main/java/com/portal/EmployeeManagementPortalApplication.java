package com.portal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main application class for the Employee Management Portal.
 */
@SpringBootApplication
public class EmployeeManagementPortalApplication {

    /**
     * Entry point of the program.
     * @param args The command-line arguments passed to the program.
     */
    public static void main(final String[] args) {
        SpringApplication.run(EmployeeManagementPortalApplication.class, args);
    }

    /**
     * Provides a ModelMapper instance for DTO to Entity mapping.
     * @return An instance of ModelMapper for DTO to Entity mapping.
     */
    @Bean
    public ModelMapper dtoToEntityMapper() {
        return new ModelMapper();
    }

    /**
     * Provides a ModelMapper instance for Entity to DTO mapping.
     * @return An instance of ModelMapper for Entity to DTO mapping.
     */
    @Bean
    public ModelMapper entityToDtoMapper() {
        return new ModelMapper();
    }

    /**
     * Provides a ModelMapper instance.
     * @return An instance of ModelMapper.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
