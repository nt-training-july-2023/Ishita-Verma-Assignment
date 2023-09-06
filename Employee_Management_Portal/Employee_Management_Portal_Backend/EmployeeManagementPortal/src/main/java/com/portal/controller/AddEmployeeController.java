package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.BeanDefinitionDsl.Role;
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

@CrossOrigin("*")
@RequestMapping("/api/admin")
@RestController
public class AddEmployeeController {

	@Autowired
	private AdminRepository userRepository;
	/**
	 * Admin Service.
	 */
	@Autowired
	private AddEmployeeService addEmployeeService;

	@PostMapping(path = "/addEmployee")
	public final String saveEmployee(@RequestBody final AdminDTO userDTO) {
		{
			return addEmployeeService.addEmployee(userDTO);
		}
	}
	
	@GetMapping("all/{roleName}")
	public List<Admin> getEmployeesByRole(@PathVariable String roleName){
		Role role =Role.valueOf(roleName);
		List<Admin> employee = userRepository.findByRole(role);

        return employee;
	}
}
