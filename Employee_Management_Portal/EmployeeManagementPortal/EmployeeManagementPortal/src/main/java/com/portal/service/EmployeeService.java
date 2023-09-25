package com.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.portal.DTO.RequestResourceDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;
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
    /**
     * Validation utility for performing data validation.
     */
    @Autowired
    private RequestResourceRepository requestResourceRepository;
    
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
                    empDto.setProjectName(project.getName());
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
        
        public final ApiResponseDTO requestResource(final RequestResourceDTO requestResourceDto){
            RequestResource requestResource =
                    dtoToRequestResource(requestResourceDto);
            requestResourceRepository.save(requestResource);
            return new ApiResponseDTO("Resource added.");
        }
        
        private RequestResource dtoToRequestResource(RequestResourceDTO requestResourceDto) {
            RequestResource requestResource = new RequestResource();
            requestResource.setComment(requestResourceDto.getComment());
            requestResource.setManagerId(requestResourceDto.getManagerId());
            requestResource.setEmpId(requestResourceDto.getEmpId());
            requestResource.setProjectId(requestResourceDto.getProjectId());
            return requestResource;
        }
        
        public final List<RequestResourceOutDTO> getAllRequests() {
            List<RequestResource> requestResourceList =
                    requestResourceRepository.findAll();
            List<RequestResourceOutDTO> returnedList = new ArrayList<>();
            for(RequestResource r: requestResourceList){
                RequestResourceOutDTO requestResourceOutDto = requestToOutDto(r);
                returnedList.add(requestResourceOutDto);
            }
            return returnedList;
        }
       
        private RequestResourceOutDTO requestToOutDto(RequestResource requestResource){
        	RequestResourceOutDTO r = new RequestResourceOutDTO();
            r.setComment(requestResource.getComment());
            r.setEmpId(requestResource.getEmpId());
            r.setManagerId(requestResource.getManagerId());
            r.setProjectId(requestResource.getProjectId());
            Optional<Employee> optionalUser =
                    userRepository.findById(requestResource.getEmpId());
            Employee user = optionalUser.get();
            r.setEmployeeName(user.getName());
            r.setEmpUserId(user.getEmpId());
            Optional<Employee> optionalManager =
                    userRepository.findById(requestResource.getManagerId());
            Employee manager = optionalManager.get();
            r.setManagerName(manager.getName());
            r.setManagerUserId(manager.getEmpId());
            Optional<Project> projectOptional =
                    projectRepository.findById(requestResource.getProjectId());
            Project project = projectOptional.get();
            r.setProjectName(project.getName());
            return r;
        }
        public void unassignEmployee(Long employeeId) {
            // Find the employee by ID
            Employee employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

            // Check if the employee is currently assigned to a project
            if (employee.getProjectId() != 0) {
                // Unassign the employee by setting their project ID to 0
                employee.setProjectId(0);
                // Save the updated employee
                userRepository.save(employee);
            } else {
                throw new IllegalStateException("Employee is not assigned to any project.");
            }
        }

        public final List<EmployeeOutDTO> searchBySkills(List<String> skills,boolean isCheck){
            System.out.println(isCheck);
//            List<Employee> employees = empRepository.findBySkillsIn(skills);
            List<Employee> allEmployees = userRepository.findByRole(Role.EMPLOYEE);
            List<Employee> returnedList = new ArrayList<>();
            List<Employee> employeesWithRequiredSkills = allEmployees.stream()
                .filter(employee -> employee.getSkills().containsAll(skills))
                .collect(Collectors.toList());
            
            if(isCheck) {
                List<Employee> unAssignedEmployees = employeesWithRequiredSkills.stream()
                        .filter(employee -> employee.getProjectId()==0)
                        .collect(Collectors.toList());
                returnedList = unAssignedEmployees;
                
            }else {
                returnedList = employeesWithRequiredSkills;
            }
            System.out.println( returnedList);
            List<EmployeeOutDTO> employeeDtoList = new ArrayList<EmployeeOutDTO>();
            for (Employee employee : returnedList) {
                EmployeeOutDTO empDTO = new EmployeeOutDTO();
                empDTO.setId(employee.getId());
                empDTO.setName(employee.getName());
                empDTO.setEmail(employee.getEmail());
                empDTO.setEmpId(employee.getEmpId());
                empDTO.setDesignation(employee.getDesignation());
                empDTO.setContactNumber(employee.getContactNumber());
                empDTO.setDob(employee.getDob());
                empDTO.setDoj(employee.getDoj());
                empDTO.setLocation(employee.getLocation());
                if (employee.getProjectId() == 0) {
                    empDTO.setProjectName(null);
                } else {
                    Project project = projectRepository.findById(employee.getProjectId()).get();
                    empDTO.setProjectName(project.getName());
                    empDTO.setProjectId(employee.getProjectId());
                }
                Employee manager = userRepository
                        .findById(employee.getManagerId()).get();
                empDTO.setManager(manager.getName());
                empDTO.setManagerId(manager.getId());
                empDTO.setSkills(employee.getSkills());
                empDTO.setRole(employee.getRole());
                employeeDtoList.add(empDTO);
            }
            return employeeDtoList;
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
