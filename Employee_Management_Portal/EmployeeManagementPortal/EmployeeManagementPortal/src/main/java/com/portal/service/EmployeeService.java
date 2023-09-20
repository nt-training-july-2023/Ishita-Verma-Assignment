package com.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ApiResponseDTO;
//import com.portal.DTO.EmployeeDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.validation.Validation;


/**
 * Service class for adding employees.
 */
@Service
public class EmployeeService {

    /**
     * Repository for managing Admin entities.
     */
    @Autowired
    private AdminRepository userRepository;

    /**
     * ModelMapper for mapping between DTOs and entities.
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * Validation utility for performing data validation.
     */
    @Autowired
    private ProjectRepository projectRepository;
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeService.class);

    /**
     * Adds an employee based on the provided AdminDTO.
     *
     * @param userDto The AdminDTO containing employee information.
     * @return The added Admin entity.
     * @throws DuplicateEntryException if same email alreadyexists.
     */
    public final ApiResponseDTO addEmployee(final AdminDTO adminDTO) {
        //Validator.addEmployeeValidation(adminDTO);
    	 
        if (!userRepository.findByEmpId(adminDTO.getEmpId()).isEmpty()) {
            LOGGER.error("Employee id already exists");
            throw new DuplicateEntryException(
                    "Employee id already exists");
        }
        // employee email exists
        if (!userRepository.findByEmail(adminDTO.getEmail()).isEmpty()) {
            LOGGER.error("Email already exists");
            throw new DuplicateEntryException("Email id already exists");
        }
        adminDTO.setEmpId(adminDTO.getEmpId());
        adminDTO.setEmail(adminDTO.getEmail());
        adminDTO.setName(adminDTO.getName());
        adminDTO.setContactNumber(adminDTO.getContactNumber());
        adminDTO.setDob(adminDTO.getDob());
        adminDTO.setDoj(adminDTO.getDoj());
        adminDTO.setLocation(adminDTO.getLocation());
        adminDTO.setDesignation(adminDTO.getDesignation());
        adminDTO.setRole(adminDTO.getRole());
        adminDTO.setSkills(adminDTO.getSkills());
        // default manager is admin
        Optional<Employee> emp = userRepository
                .findByEmail("ankita.sharma@nucleusteq.com");
        adminDTO.setManagerId(emp.get().getId());
        adminDTO.setProjectId(0);
      
        Employee empEntity = this.dtotoEntity(adminDTO);

        this.userRepository.save(empEntity);
        return new ApiResponseDTO("Employee Added Succesfully");
    }
    /**
     * Drop Down Manager ID and Name.
     * @param empId Id of Manager
     * @return employeeName
     */
    public final Optional<Employee> getEmployeeById(final long id){
        return userRepository.findById(id);
    }
    
    public final List<EmployeeOutDTO> getEmployeeByRole(String roleName){
    	Role role = Role.valueOf(roleName);
    	 List<Employee> employees = userRepository.findByRole(role);
         //System.out.println(employees);
         List<EmployeeOutDTO> employeeDtoList = new ArrayList<EmployeeOutDTO>();
         for (Employee employee : employees) {
             EmployeeOutDTO empDto = new EmployeeOutDTO();
             empDto.setId(employee.getId());
             empDto.setName(employee.getName());
             empDto.setEmail(employee.getEmail());
             empDto.setEmpId(employee.getEmpId());
             empDto.setDesignation(employee.getDesignation());
             empDto.setContactNumber(employee.getContactNumber());
             empDto.setDob(employee.getDob());
             empDto.setDoj(employee.getDoj());
             empDto.setLocation(employee.getLocation());
             if (employee.getProjectId() == 0) {
                 empDto.setProjectName(null);
             } else {
                 Project project = projectRepository.findById(employee.getProjectId())
                         .get();
                 empDto.setProjectName(project.getName());
             }
             Employee manager = userRepository
                     .findById(employee.getManagerId()).get();
             empDto.setManager(manager.getName());
             empDto.setSkills(employee.getSkills());
             empDto.setRole(employee.getRole());
         employeeDtoList.add(empDto);
         }
         return employeeDtoList;
    	
    	
    }
        public final EmployeeOutDTO getEmployeeByEmail(String email){
        	LOGGER.error("Employee id already exists");
        	Employee employee = userRepository.findByEmail(email).get();
            EmployeeOutDTO empDto = new EmployeeOutDTO();
            if (employee != null) {
                empDto.setId(employee.getId());
                empDto.setName(employee.getName());
                empDto.setEmail(employee.getEmail());
                empDto.setEmpId(employee.getEmpId());
                empDto.setDesignation(employee.getDesignation());
                empDto.setContactNumber(employee.getContactNumber());
                empDto.setDob(employee.getDob());
                empDto.setDoj(employee.getDoj());
                empDto.setLocation(employee.getLocation());
                empDto.setRole(employee.getRole());
                Employee manager = userRepository
                        .findById(employee.getManagerId()).get();
                empDto.setManager(manager.getName());
                empDto.setSkills(employee.getSkills());
               
                if (employee.getProjectId() == 0) {
                    empDto.setProjectId(null);
                } else {
                    Project project = projectRepository
                            .findById(employee.getProjectId()).get();
                    empDto.setProjectId(project.getName());
                }
//                Employee manager = userRepository
//                        .findById(employee.getManagerId()).get();
//                empDto.setManagerId(manager.getName());
//                empDto.setSkills(null);
            }
            return empDto;
        }
//        /**
//         * update project to employee.
//         * @param id employee primary key id
//         * @param projectId project id
//         * @param managerId manager id
//         * @return general response dto
//         */
        public final ApiResponseDTO updatedProject(Long id,Long projectId,Long managerId) {
            
            Employee employee=userRepository.findById(id).orElse(null);
            if(employee!=null) {
                employee.setProjectId(projectId);
                employee.setManagerId(managerId);
                userRepository.save(employee);
                return new ApiResponseDTO("Updated Suceesfully");
            }
            LOGGER.error("Employee not found");
            throw new ResourceNotFoundException("Employee not found");
            }
        /**
         * Update an employee's skills.
         *
         * @param id the employee ID
         * @param skills the updated list of skills
         * @return an API response indicating the result of the operation
         */
        public final ApiResponseDTO updateSkills(final long id,
                final List<String> skills) {
            Employee emp = userRepository.findById(id).get();
            emp.setSkills(skills);
            userRepository.save(emp);
            return new ApiResponseDTO("Skills Updated Successfully");
        }
   // dto to entity
      private Employee dtotoEntity(final AdminDTO adminDTO) {
          // AdminEntity adminEntity = new AdminEntity();
          return this.modelMapper.map(adminDTO, Employee.class);
      }
  //entity to dto
      /**
       * @param empEntity employee instance
       * @return employee dto
       */
      private AdminDTO entitytoDto(final Employee empEntity) {
          // AdminDTO adminDto = new AdminDTO();
          return this.modelMapper.map(empEntity, AdminDTO.class);
      }
}
