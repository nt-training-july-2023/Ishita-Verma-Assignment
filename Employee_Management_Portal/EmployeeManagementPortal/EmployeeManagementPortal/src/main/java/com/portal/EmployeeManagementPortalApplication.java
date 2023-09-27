package com.portal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.LoginResponseDTO;

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
    @Bean
    public ApiResponseDTO apiResponseDTO() {
    	return new ApiResponseDTO();
    }
    @Bean
    public LoginResponseDTO loginResponseDTO() {
    	return new LoginResponseDTO();
    }

}
