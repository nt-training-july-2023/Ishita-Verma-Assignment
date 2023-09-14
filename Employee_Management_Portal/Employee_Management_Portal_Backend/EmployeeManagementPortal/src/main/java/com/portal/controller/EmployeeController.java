package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.entities.Admin;
import com.portal.repository.AdminRepository;
import com.portal.service.AddEmployeeService;
import com.portal.entities.Role;

/**
 * Controller class for managing employee-related operations.
 */
@CrossOrigin("*")
@RequestMapping("/api/admin")
@RestController
public class EmployeeController {

    /**
     * Repository for managing admin data.
     */
    @Autowired
    private AdminRepository userRepository;

    /**
     * Service for adding employees.
     */
    @Autowired
    private AddEmployeeService addEmployeeService;

    /**
     * Adds a new employee.
     *
     * @param userDTO The AdminDTO containing employee details.
     * @return The added employee.
     */
    @PostMapping(path = "/addEmployee")
    public final Admin saveEmployee(
            @RequestBody @Valid final AdminDTO userDTO) {
        return addEmployeeService.addEmployee(userDTO);
    }

    /**
     * Retrieves a list of employees based on their role.
     *
     * @param roleName The role name for filtering employees.
     * @return A list of employees with the specified role.
     */
    final @GetMapping("all/{roleName}") public List<Admin> getEmployeesByRole(
            @PathVariable final String roleName) {
        Role role = Role.valueOf(roleName);
        List<Admin> employees = userRepository.findByRole(role);
        return employees;
    }
}
