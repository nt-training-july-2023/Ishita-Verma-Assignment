package com.portal.DTO;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Data Transfer Object (DTO) representing admin registration information.
 */
@Component
public class EmployeeInDTO {

    /**
     * The unique ID of the admin.
     */
    private Long Id;

    /**
     * The employee ID of the admin.
     */
	@NotBlank(message = "EmpId is required")
    @Pattern(regexp = "N\\d{4}$", message = "EmpID should be NXXXX.")
    private String empId;

    /**
     * The name of the admin.
     */
	@NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z\\s]+$",
    message = "Name should containe letter only.")
    private String name;

    /**
     * The email address of the admin.
     */
	 @NotEmpty(message = "Email is required")
	 @Pattern(regexp = ".*@nucleusteq\\.com$",
	 message = "Email should ends with nucleusteq.com.")
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
    @NotNull
    private Location location;

    /**
     * The designation of the admin.
     */
    @NotNull
    private Designation designation;

    /**
     * The contact number of the admin.
     */
    @NotBlank(message = "Contact No is required")
    @Pattern(regexp = "^[0-9]{10}$",
    message = "Contact no should conatins 10 digits only")
    private String contactNumber;

    /**
     * The password for the admin's account.
     */
    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^.{8,}$",
    message = "Password should contain only 8 digits.")
    private String password;
    /**
     * The user role of the admin.
     */
    @NotNull(message = "Role should not be empty")
    private Role role;

    /**
     * The manager's name for the admin.
     */
    private String manager;

    /**
     * The manager's ID for the admin.
     */
//    @NotNull(message = "ManagerId should not be empty")
    private Long managerId;

    /**
     * The ID of the project associated with the admin.
     */
    private Long projectId;

    /**
     * The name of the project associated with the admin.
     */
    private String project;

    /**
     * The list of skills associated with the admin.
     */
    private List<String> skills;
        /**
         * Unique identifier for the admin user.
         * @return The admin's unique identifier.
         */
        public Long getId() {
            return Id;
        }

        /**
         * Sets the unique identifier for the admin user.
         * @param id The admin's unique identifier.
         */
        public void setId(Long id) {
            Id = id;
        }

        /**
         * Gets the employee ID of the admin.
         * @return The employee ID of the admin.
         */
        public String getEmpId() {
            return empId;
        }

        /**
         * Sets the employee ID of the admin.
         * @param empId The employee ID of the admin.
         */
        public void setEmpId(String empId) {
            this.empId = empId;
        }

        /**
         * Gets the name of the admin.
         * @return The name of the admin.
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the admin.
         * @param name The name of the admin.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets the email address of the admin.
         * @return The email address of the admin.
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the email address of the admin.
         * @param email The email address of the admin.
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * Gets the date of birth of the admin.
         * @return The date of birth of the admin.
         */
        public String getDob() {
            return dob;
        }

        /**
         * Sets the date of birth of the admin.
         *
         * @param dob The date of birth of the admin.
         */
        public void setDob(String dob) {
            this.dob = dob;
        }

        /**
         * Gets the date of joining of the admin.
         * @return The date of joining of the admin.
         */
        public String getDoj() {
            return doj;
        }

        /**
         * Sets the date of joining of the admin.
         * @param doj The date of joining of the admin.
         */
        public void setDoj(String doj) {
            this.doj = doj;
        }

        /**
         * Gets the location of the admin.
         * @return The location of the admin.
         */
        public Location getLocation() {
            return location;
        }

        /**
         * Sets the location of the admin.
         * @param location The location of the admin.
         */
        public void setLocation(Location location) {
            this.location = location;
        }

        /**
         * Gets the designation of the admin.
         * @return The designation of the admin.
         */
        public Designation getDesignation() {
            return designation;
        }

        /**
         * Sets the designation of the admin.
         * @param designation The designation of the admin.
         */
        public void setDesignation(Designation designation) {
            this.designation = designation;
        }

        /**
         * Gets the contact number of the admin.
         * @return The contact number of the admin.
         */
        public String getContactNumber() {
            return contactNumber;
        }

        /**
         * Sets the contact number of the admin.
         * @param contactNumber The contact number of the admin.
         */
        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        /**
         * Gets the password of the admin.
         * @return The password of the admin.
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets the password of the admin.
         * @param password The password of the admin.
         */
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * Gets the role of the admin.
         * @return The role of the admin.
         */
        public Role getRole() {
            return role;
        }

        /**
         * Sets the role of the admin.
         * @param role The role of the admin.
         */
        public void setRole(Role role) {
            this.role = role;
        }

        /**
         * Gets the manager of the admin.
         * @return The manager of the admin.
         */
        public String getManager() {
            return manager;
        }

        /**
         * Sets the manager of the admin.
         * @param manager The manager of the admin.
         */
        public void setManager(String manager) {
            this.manager = manager;
        }

        /**
         * Gets the manager's unique identifier.
         * @return The manager's unique identifier.
         */
        public Long getManagerId() {
            return managerId;
        }

        /**
         * Sets the manager's unique identifier.
         * @param managerId The manager's unique identifier.
         */
        public void setManagerId(Long managerId) {
            this.managerId = managerId;
        }

        /**
         * Gets the unique identifier for the project associated with the admin.
         * @return The project's unique identifier.
         */
        public Long getProjectId() {
            return projectId;
        }

        /**
         * Sets the unique identifier for the project associated with the admin.
         * @param projectId The project's unique identifier.
         */
        public void setProjectId(Long projectId) {
            this.projectId = projectId;
        }

        /**
         * Gets the name of the project associated with the admin.
         * @return The name of the project.
         */
        public String getProject() {
            return project;
        }

        /**
         * Sets the name of the project associated with the admin.
         * @param project The name of the project.
         */
        public void setProject(String project) {
            this.project = project;
        }

        /**
         * Gets the list of skills possessed by the admin.
         * @return The list of skills.
         */
        public List<String> getSkills() {
            return skills;
        }

        /**
         * Sets the list of skills possessed by the admin.
         * @param skills The list of skills.
         */
        public void setSkills(List<String> skills) {
            this.skills = skills;
        }
 
    /**
     * Calculates the hash code for this AdminDTO object.
     * @return The hash code value.
     */
	@Override
	public int hashCode() {
		return Objects.hash(Id, contactNumber, designation, dob, doj, email, empId, location, manager, managerId, name,
				password, project, projectId, role, skills);
	}
	/**
     * Compares this AdminDTO object to another object for equality.
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeInDTO other = (EmployeeInDTO) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(contactNumber, other.contactNumber)
				&& designation == other.designation && Objects.equals(dob, other.dob) && Objects.equals(doj, other.doj)
				&& Objects.equals(email, other.email) && Objects.equals(empId, other.empId)
				&& location == other.location && Objects.equals(manager, other.manager)
				&& Objects.equals(managerId, other.managerId) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(project, other.project)
				&& Objects.equals(projectId, other.projectId) && role == other.role
				&& Objects.equals(skills, other.skills);
	}
	/**
     * Returns a string representation of the AdminDTO object.
     * @return A string containing the values of all fields.
     */
	@Override
	public String toString() {
		return "AdminDTO [Id=" + Id + ", empId=" + empId + ", name=" + name + ", email=" + email + ", dob=" + dob
				+ ", doj=" + doj + ", location=" + location + ", designation=" + designation + ", contactNumber="
				+ contactNumber + ", password=" + password + ", role=" + role + ", manager=" + manager + ", managerId="
				+ managerId + ", projectId=" + projectId + ", project=" + project + ", skills=" + skills + "]";
	}
    
}