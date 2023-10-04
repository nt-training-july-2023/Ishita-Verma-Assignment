package com.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.constants.ErrorConstants;
import com.portal.constants.SuccessConstants;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.entities.Role;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;

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
     * Repository for request resource.
     */
    @Autowired
    private RequestResourceService requestResourceService;
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
    /**
     * Logger for info and error.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeService.class);

    /**
     * Adds an employee based on the provided AdminDTO.
     * @param adminDTO The AdminDTO containing employee information.
     * @return The added Admin entity.
     * @throws DuplicateEntryException if same email alreadyexists.
     */
    public final ApiResponseDTO addEmployee(final EmployeeInDTO adminDTO) {
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
//        Optional<Employee> emp = userRepository.findById(1L);
        adminDTO.setManagerId(emp.get().getId());
        adminDTO.setProjectId(0L);

        ApiResponseDTO response = new ApiResponseDTO();
        Employee empEntity = this.dtotoEntity(adminDTO);

        this.userRepository.save(empEntity);
        response.setMessage(SuccessConstants.EMPLOYEE_ADDED);
        return response;
    }

    /**
     * Drop Down Manager ID and Name.
     * @param id Id of Manager
     * @return employeeName
     */
    public final EmployeeOutDTO getEmployeeById(final Long id) {
        // TODO Auto-generated method stub
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Id does not exists");
        }
        Optional<Employee> optionalEmployee = userRepository.findById(id);
        Employee employee = optionalEmployee
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee Id does not exists"));
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
            empDto.setManagerId(employee.getManagerId());
            empDto.setProjectId(employee.getProjectId());
            if (employee.getProjectId() == 0) {
                empDto.setProjectName("N/A");
            } else {
                Project project = projectRepository
                        .findById(employee.getProjectId()).get();
                empDto.setProjectName(project.getName());
            }
            Employee manager = userRepository
                    .findById(employee.getManagerId()).get();
            empDto.setManager(manager.getName());
            empDto.setSkills(employee.getSkills());
        }
        return empDto;
    }

    /**
     * Retrieves a list of employees based on the specified role.
     * @param roleName The name of the role for which to retrieve employees.
     * @return A list of EmployeeOutDTO representing employees with
     * the specified role.
     */
    public final List<EmployeeOutDTO> getEmployeeByRole(final Role roleName) {
//        Role role = Role.roleName;
        List<Employee> employees = userRepository.findByRole(roleName);
        // System.out.println(employees);
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
                Project project = projectRepository
                        .findById(employee.getProjectId()).get();
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

    /**
     * Retrieves an object based on the specified email address.
     * @param email The email address of the employee to retrieve.
     * @return An object representing the employee with
     * the specified email address,or null if not found.
     */
    public final EmployeeOutDTO getEmployeeByEmail(final String email) {
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
            empDto.setManagerId(employee.getManagerId());
            empDto.setProjectId(employee.getProjectId());
            Employee manager = userRepository
                    .findById(employee.getManagerId()).get();
            empDto.setManager(manager.getName());
            empDto.setSkills(employee.getSkills());

            if (employee.getProjectId() == 0) {
                empDto.setProjectName("");
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

    /**
     * update project to employee.
     * @param id        employee primary key id
     * @param projectId project id
     * @param managerId manager id
     * @return general response dto
     */
    public final ApiResponseDTO updatedProject(final Long id,
            final Long projectId, final Long managerId) {

        Employee employee = userRepository.findById(id).orElse(null);
        if (employee != null) {

            employee.setProjectId(projectId);
            employee.setManagerId(managerId);
            userRepository.save(employee);
            List<RequestResource> request = requestResourceRepository
                    .findByEmployeeId(id);
            for (RequestResource req : request) {
                requestResourceService.rejectRequest(req.getResourceId());
            }
            ApiResponseDTO response = new ApiResponseDTO();
            response.setMessage("Updated Suceesfully");
            return response;
        }
        LOGGER.error("Employee not found");
        throw new ResourceNotFoundException(ErrorConstants.EMPLOYEE_NOT_FOUND );
    }
    /**
     * Update an employee's skills.
     * @param id the employee ID
     * @param updatedSkills the updated list of skills
     * @return an API response indicating the result of the operation.
     */
    public final ApiResponseDTO updateSkills(final Long id,
            final List<String> updatedSkills) {
        // TODO Auto-generated method stub
        Employee employee = userRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setSkills(updatedSkills);
            userRepository.save(employee);
            ApiResponseDTO response = new ApiResponseDTO();
            response.setMessage("Updated Skills");
            return response;
        }
        LOGGER.error("Employee not found");
        throw new ResourceNotFoundException(ErrorConstants.EMPLOYEE_NOT_FOUND );
    }

    /**
     * Creates a new resource request.
     * @param requestResourceDto The DTO representing the resource request.
     * @return a response indicating the success of the operation.
     */
    public final ApiResponseDTO requestResource(
            final RequestResourceInDTO requestResourceDto) {
        RequestResource requestResource = dtoToRequestResource(
                requestResourceDto);
        requestResourceRepository.save(requestResource);
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage(SuccessConstants.RESOURCE_ADDED);
        return response;
    }

    /**
     * Converts a RequestResourceInDTO object into a RequestResource entity.
     * @param requestResourceDto The DTO object to be converted.
     * @return A RequestResource entity representing the converted DTO.
     */
    public RequestResource dtoToRequestResource(
           final RequestResourceInDTO requestResourceDto) {
        RequestResource requestResource = new RequestResource();
        requestResource.setComment(requestResourceDto.getComment());
        requestResource.setManagerId(requestResourceDto.getManagerId());
        requestResource.setEmployeeId(requestResourceDto.getEmployeeId());
        requestResource.setProjectId(requestResourceDto.getProjectId());
        return requestResource;
    }

    /**
     * Retrieves all request resources from the
     * repository and converts them into a
     * list of RequestResourceOutDTO.
     * @return A list of RequestResourceOutDTO objects representing the request
     *         resources.
     */
    public final List<RequestResourceOutDTO> getAllRequests() {
        List<RequestResource> requestResourceList = requestResourceRepository
                .findAll();
        List<RequestResourceOutDTO> returnedList = new ArrayList<>();
        for (RequestResource request : requestResourceList) {
            RequestResourceOutDTO requestResourceOutDto = requestToOutDto(
                    request);
            returnedList.add(requestResourceOutDto);
        }
        return returnedList;
    }

    /**
     * Converts a entity to a OutDTO.
     * @param requestResource entity to convert.
     * @return data representing the converted entity.
     */
    public RequestResourceOutDTO requestToOutDto(
           final RequestResource requestResource) {
        RequestResourceOutDTO request = new RequestResourceOutDTO();
        request.setComment(requestResource.getComment());
        request.setEmpId(requestResource.getEmployeeId());
        request.setManagerId(requestResource.getManagerId());
        request.setProjectId(requestResource.getProjectId());
        Optional<Employee> optionalUser = userRepository
                .findById(requestResource.getEmployeeId());
        Employee user = optionalUser.get();
        request.setEmployeeName(user.getName());
        request.setEmpUserId(user.getEmpId());
        Optional<Employee> optionalManager = userRepository
                .findById(requestResource.getManagerId());
        Employee manager = optionalManager.get();
        request.setManagerName(manager.getName());
        request.setManagerUserId(manager.getEmpId());
        Optional<Project> projectOptional = projectRepository
                .findById(requestResource.getProjectId());
        Project project = projectOptional.get();
        request.setProjectName(project.getName());
        return request;
    }

    /**
     * Unassigns an employee from a project by setting their project ID to 0.
     * @param employeeId The ID of the employee to unassign.
     * @throws ResourceNotFoundException If the
     * employee with the specified ID is not found.
     * @throws IllegalStateException If the employee
     * is not currently assigned to any project.
     */
    public final ApiResponseDTO unassignEmployee(final Long id) {
        // TODO Auto-generated method stub
        Employee employee = userRepository.findById(id).get();
        Employee emp = userRepository.findByEmail("ankita.sharma@nucleusteq.com")
                .get();
        employee.setManagerId(emp.getId());
        employee.setProjectId(0L);
        this.userRepository.save(employee);
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage("Project unassigned");
        return response;
    }

    /**
     * Retrieves a list of employees based on skills and assignment status.
     * @param skills  The list of required skills for filtering.
     * @param isCheck If true, filters unassigned employees;
     * if false, filters all employees with required skills.
     * @return A list of EmployeeOutDTO objects representing
     * employees based on the provided criteria.
     */
    public final List<EmployeeOutDTO> skillsAndUnassign(
           final List<String> skills, final boolean isCheck) {
//          List<Employee> employees = empRepository.findBySkillsIn(skills);
        List<Employee> allEmployees = userRepository
                .findByRole(Role.EMPLOYEE);
        List<Employee> returnedList = new ArrayList<>();
        if (skills.isEmpty()) {
            List<Employee> unAssignedEmployees = allEmployees.stream()
                    .filter(employee -> employee.getProjectId() == 0)
                    .collect(Collectors.toList());
            returnedList = unAssignedEmployees;
        } else {
            List<Employee> employeesWithRequiredSkills = allEmployees
                    .stream()
                    .filter(employee -> employee.getSkills().stream()
                            .anyMatch(skills::contains))
                    .collect(Collectors.toList());
            if (isCheck) {
                List<Employee> unAssignedEmployees = employeesWithRequiredSkills
                        .stream()
                        .filter(employee -> employee.getProjectId() == 0)
                        .collect(Collectors.toList());
                returnedList = unAssignedEmployees;
            } else {
                returnedList = employeesWithRequiredSkills;
            }
        }
        List<EmployeeOutDTO> employeeDtoList = new ArrayList<EmployeeOutDTO>();
        for (Employee employee : returnedList) {
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
                Project project = projectRepository
                        .findById(employee.getProjectId()).get();
                empDto.setProjectName(project.getName());
                empDto.setProjectId(employee.getProjectId());
            }
            Employee manager = userRepository
                    .findById(employee.getManagerId()).get();
            empDto.setManager(manager.getName());
            empDto.setManagerId(manager.getId());
            empDto.setSkills(employee.getSkills());
            empDto.setRole(employee.getRole());
            employeeDtoList.add(empDto);
        }
        return employeeDtoList;
    }

    /**
     * @param userDto to entity.
     * @return employee dto
     */
    private Employee dtotoEntity(final EmployeeInDTO userDto) {
        Employee user = new Employee();
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        user.setProjectId(userDto.getProjectId());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());
        user.setDoj(userDto.getDoj());
        user.setEmail(userDto.getEmail());
        user.setEmpId(userDto.getEmpId());
        user.setLocation(userDto.getLocation());
        user.setDesignation(userDto.getDesignation());
        user.setContactNumber(userDto.getContactNumber());
        user.setSkills(userDto.getSkills());
        user.setManagerId(userDto.getManagerId());
        return user;
    }
}
