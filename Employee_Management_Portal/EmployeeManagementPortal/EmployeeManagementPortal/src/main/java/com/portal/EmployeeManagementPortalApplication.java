package com.portal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementPortalApplication.class, args);
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
