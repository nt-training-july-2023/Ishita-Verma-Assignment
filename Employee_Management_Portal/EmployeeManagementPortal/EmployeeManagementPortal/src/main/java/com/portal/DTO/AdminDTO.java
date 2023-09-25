package com.portal.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) representing admin registration information.
 */
@Component
public class AdminDTO {

    /**
     * The unique ID of the admin.
     */
    private long Id;

    /**
     * The employee ID of the admin.
     */
    @NotBlank(message = "Employee ID should not be empty")
    private String empId;

    /**
     * The name of the admin.
     */
    @NotBlank(message = "Name should not be empty")
    private String name;

    /**
     * The email address of the admin.
     */
    @NotBlank(message = "Email ID should not be empty")
    private String email;

    /**
     * The date of birth of the admin.
     */
    @NotBlank(message = "Date of Birth should not be empty")
    private String dob;

    /**
     * The date of joining of the admin.
     */
    @NotBlank(message = "Date of Joining should not be empty")
    private String doj;

    /**
     * The location of the admin.
     */
    private Location location;

    /**
     * The designation of the admin.
     */
    private Designation designation;

    /**
     * The contact number of the admin.
     */
    @NotBlank(message = "Phone number should not be empty")
    private String contactNumber;

    /**
     * The password for the admin's account.
     */
    @NotBlank(message = "Password should not be empty")
    private String password;
    /**
     * The user role of the admin.
     */
    private Role role;

    /**
     * The manager's name for the admin.
     */
    private String manager;

    /**
     * The manager's ID for the admin.
     */
    private Long managerId;

    /**
     * The ID of the project associated with the admin.
     */
    private long projectId;

    /**
     * The name of the project associated with the admin.
     */
    private String project;

    /**
     * The list of skills associated with the admin.
     */
    private List<String> skills;
    
    

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

	/**
	 * @param id
	 * @param empId
	 * @param name
	 * @param email
	 * @param dob
	 * @param doj
	 * @param location
	 * @param designation
	 * @param contactNumber
	 * @param password
	 * @param role
	 * @param manager
	 * @param managerId
	 * @param projectId
	 * @param project
	 * @param skills
	 */
	public AdminDTO(long id, @NotBlank(message = "Employee ID should not be empty") String empId,
			@NotBlank(message = "Name should not be empty") String name,
			@NotBlank(message = "Email ID should not be empty") String email,
			@NotBlank(message = "Date of Birth should not be empty") String dob,
			@NotBlank(message = "Date of Joining should not be empty") String doj, Location location,
			Designation designation, @NotBlank(message = "Phone number should not be empty") String contactNumber,
			@NotBlank(message = "Password should not be empty") String password, Role role, String manager,
			Long managerId, long projectId, String project, List<String> skills) {
		super();
		Id = id;
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.doj = doj;
		this.location = location;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
		this.manager = manager;
		this.managerId = managerId;
		this.projectId = projectId;
		this.project = project;
		this.skills = skills;
	}

	/**
	 * 
	 */
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}