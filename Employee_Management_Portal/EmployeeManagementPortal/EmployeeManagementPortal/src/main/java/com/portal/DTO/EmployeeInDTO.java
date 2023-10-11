package com.portal.DTO;

import java.util.ArrayList;
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
    private Long id;

    /**
     * The employee ID of the admin.
     */
    @NotBlank(message = "EmpId is required")
    @Pattern(regexp = "[Nn]\\d{4}$", message = "EmpID should be NXXXX.")
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
        return id;
    }

    /**
     * Sets the unique identifier for the admin user.
     * @param idParam The admin's unique identifier.
     */
    public void setId(final Long idParam) {
        this.id = idParam;
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
     * @param empIdParam The employee ID of the admin.
     */
    public void setEmpId(final String empIdParam) {
        this.empId = empIdParam;
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
     * @param nameParam The name of the admin.
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
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
     * @param emailParam The email address of the admin.
     */
    public void setEmail(final String emailParam) {
        this.email = emailParam;
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
     * @param dobParam The date of birth of the admin.
     */
    public void setDob(final String dobParam) {
        this.dob = dobParam;
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
     * @param dojParam The date of joining of the admin.
     */
    public void setDoj(final String dojParam) {
        this.doj = dojParam;
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
     * @param locationParam The location of the admin.
     */
    public void setLocation(final Location locationParam) {
        this.location = locationParam;
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
     * @param designationParam The designation of the admin.
     */
    public void setDesignation(final Designation designationParam) {
        this.designation = designationParam;
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
     * @param contactNumberParam The contact number of the admin.
     */
    public void setContactNumber(final String contactNumberParam) {
        this.contactNumber = contactNumberParam;
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
     * @param passwordParam The password of the admin.
     */
    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
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
     * @param roleParam The role of the admin.
     */
    public void setRole(final Role roleParam) {
        this.role = roleParam;
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
     * @param managerParam The manager of the admin.
     */
    public void setManager(final String managerParam) {
        this.manager = managerParam;
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
     * @param managerIdParam The manager's unique identifier.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
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
     * @param projectIdParam The project's unique identifier.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
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
     * @param projectParam The name of the project.
     */
    public void setProject(final String projectParam) {
        this.project = projectParam;
    }

    /**
     * Gets the list of skills possessed by the admin.
     * @return The list of skills.
     */
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }


    /**
     * Sets the list of skills possessed by the admin.
     * @param skillsParam The list of skills.
     */
    public final void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }

    /**
     * Calculates the hash code for this AdminDTO object.
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, contactNumber, designation, dob, doj,
                email, empId, location, manager, managerId, name, password,
                project, projectId, role, skills);
    }

    /**
     * Compares this AdminDTO object to another object for equality.
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EmployeeInDTO other = (EmployeeInDTO) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(contactNumber, other.contactNumber)
                && designation == other.designation
                && Objects.equals(dob, other.dob)
                && Objects.equals(doj, other.doj)
                && Objects.equals(email, other.email)
                && Objects.equals(empId, other.empId)
                && location == other.location
                && Objects.equals(manager, other.manager)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(name, other.name)
                && Objects.equals(password, other.password)
                && Objects.equals(project, other.project)
                && Objects.equals(projectId, other.projectId)
                && role == other.role
                && Objects.equals(skills, other.skills);
    }

    /**
     * Returns a string representation of the AdminDTO object.
     * @return A string containing the values of all fields.
     */
    @Override
    public String toString() {
        return "EmployeeInDTO [Id=" + id + ", empId=" + empId + ", name=" + name
                + ", email=" + email + ", dob=" + dob + ", doj=" + doj
                + ", location=" + location + ", designation=" + designation
                + ", contactNumber=" + contactNumber + ", password="
                + password + ", role=" + role + ", manager=" + manager
                + ", managerId=" + managerId + ", projectId=" + projectId
                + ", project=" + project + ", skills=" + skills + "]";
    }

}
