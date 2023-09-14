package com.portal.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

/**
 * Data Transfer Object (DTO) representing admin registration information.
 */

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
    private String managerId;

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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
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

    public AdminDTO(long id,
            @NotBlank(message = "Employee ID should not be empty") String empId,
            @NotBlank(message = "Name should not be empty") String name,
            @NotBlank(message = "Email ID should not be empty") String email,
            @NotBlank(message = "Date of Birth should not be empty") String dob,
            @NotBlank(message = "Date of Joining should not be empty") String doj,
            Location location, Designation designation,
            @NotBlank(message = "Phone number should not be empty") String contactNumber,
            @NotBlank(message = "Password should not be empty") String password,
            Role role, String manager, String managerId, long projectId,
            String project, List<String> skills) {
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

    public AdminDTO() {
        super();
    }

    /**
     * Overrides the equals method to compare AdminDTO objects for equality.
     *
     * @param o The object to compare to this AdminDTO.
     * @return True if the objects are equal, false otherwise.
     */
    final @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdminDTO adminDTO = (AdminDTO) o;
        return Id == adminDTO.Id && Objects.equals(empId, adminDTO.empId)
                && Objects.equals(name, adminDTO.name)
                && Objects.equals(email, adminDTO.email)
                && Objects.equals(dob, adminDTO.dob)
                && Objects.equals(doj, adminDTO.doj)
                && Objects.equals(location, adminDTO.location)
                && Objects.equals(designation, adminDTO.designation)
                && Objects.equals(contactNumber, adminDTO.contactNumber)
                && Objects.equals(password, adminDTO.password)
                && role == adminDTO.role
                && Objects.equals(manager, adminDTO.manager)
                && Objects.equals(managerId, adminDTO.managerId)
                && projectId == adminDTO.projectId
                && Objects.equals(project, adminDTO.project)
                && Objects.equals(skills, adminDTO.skills);
    }

    /**
     * Overrides the hashCode method to generate a hash code for this AdminDTO.
     *
     * @return The hash code for this AdminDTO.
     */
    final @Override public int hashCode() {
        return Objects.hash(Id, empId, name, email, dob, doj, location,
                designation, contactNumber, password, role, manager,
                managerId, projectId, project, skills);
    }

    

    /**
     * Overrides the toString method to provide a string representation of this
     * AdminDTO.
     *
     * @return A string representation of this AdminDTO.
     */
    final @Override public String toString() {
        return "AdminDTO{" + "Id=" + Id + ", empId='" + empId + '\''
                + ", name='" + name + '\'' + ", email='" + email + '\''
                + ", dob='" + dob + '\'' + ", doj='" + doj + '\''
                + ", location=" + location + ", designation=" + designation
                + ", contactNumber='" + contactNumber + '\''
                + ", password='" + password + '\'' + ", role=" + role
                + ", manager='" + manager + '\'' + ", managerId='"
                + managerId + '\'' + ", projectId=" + projectId
                + ", project='" + project + '\'' + ", skills=" + skills
                + '}';
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    public void setSkills(List<String> skills) {
        this.skills = new ArrayList<>(skills);
    }
}
