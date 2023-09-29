package com.portal.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

/**
 * Entity class representing an Admin.
 */
@Entity
@Table(name = "employee")
public class Employee {
    /**
     * Unique identifier for the admin.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    /**
     * EmployeeController ID of the admin.
     */
    @Column(unique = true)
    private String empId;

    /**
     * Name of the admin.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Email address of the admin.
     */
    @Column(nullable = false)
    private String email;

    /**
     * Date of birth of the admin.
     */
    @Column(nullable = false)
    private String dob;

    /**
     * Date of joining of the admin.
     */
    @Column(nullable = false)
    private String doj;

    /**
     * Location where the admin is based.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Location location;

    /**
     * Designation of the admin.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Designation designation;

    /**
     * Contact number of the admin.
     */
    @Column(nullable = false)
    private String contactNumber;

    /**
     * role of user.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * project of user.
     */
    @Column
    private Long projectId;
    /**
     * Password of the user.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Skills of the user.
     */
    @Column
    private List<String> skills;
    /**
     * Manager of the user.
     */
    @Column
    private Long managerId;
    /**
     * Get the unique identifier of the employee.
     *
     * @return The unique identifier.
     */
    public Long getId() {
        return Id;
    }

    /**
     * Set the unique identifier of the employee.
     * @param id The unique identifier to set.
     */
    public void setId(final Long id) {
        Id = id;
    }

    /**
     * Get the employee ID.
     * @return The employee ID.
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Set the employee ID.
     * @param empId The employee ID to set.
     */
    public void setEmpId(final String empId) {
        this.empId = empId;
    }

    /**
     * Get the name of the employee.
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the employee.
     * @param name The name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get the email of the employee.
     * @return The email of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the employee.
     * @param email The email to set.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Get the date of birth (DOB) of the employee.
     * @return The DOB of the employee.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Set the date of birth (DOB) of the employee.
     * @param dob The DOB to set.
     */
    public void setDob(final String dob) {
        this.dob = dob;
    }

    /**
     * Get the date of joining (DOJ) of the employee.
     * @return The DOJ of the employee.
     */
    public String getDoj() {
        return doj;
    }

    /**
     * Set the date of joining (DOJ) of the employee.
     * @param doj The DOJ to set.
     */
    public void setDoj(final String doj) {
        this.doj = doj;
    }

    /**
     * Get the location of the employee.
     * @return The location of the employee.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location of the employee.
     * @param location The location to set.
     */
    public void setLocation(final Location location) {
        this.location = location;
    }

    /**
     * Get the designation of the employee.
     * @return The designation of the employee.
     */
    public Designation getDesignation() {
        return designation;
    }

    /**
     * Set the designation of the employee.
     * @param designation The designation to set.
     */
    public void setDesignation(final Designation designation) {
        this.designation = designation;
    }

    /**
     * Get the contact number of the employee.
     * @return The contact number of the employee.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Set the contact number of the employee.
     * @param contactNumber The contact number to set.
     */
    public void setContactNumber(final String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Get the role of the employee.
     * @return The role of the employee.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set the role of the employee.
     * @param role The role to set.
     */
    public void setRole(final Role role) {
        this.role = role;
    }

    /**
     * Get the project ID associated with the employee.
     * @return The project ID.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Set the project ID associated with the employee.
     * @param projectId The project ID to set.
     */
    public void setProjectId(final Long projectId) {
        this.projectId = projectId;
    }

    /**
     * Get the password of the employee.
     * @return The password of the employee.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the employee.
     * @param password The password to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Get the list of skills associated with the employee.
     * @return The list of skills.
     */
    public List<String> getSkills() {
        return skills;
    }

    /**
     * Set the list of skills associated with the employee.
     * @param skills The list of skills to set.
     */
    public void setSkills(final List<String> skills) {
        this.skills = skills;
    }

    /**
     * Get the manager ID of the employee.
     * @return The manager ID.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the manager ID of the employee.
     * @param managerId The manager ID to set.
     */
    public void setManagerId(final Long managerId) {
        this.managerId = managerId;
    }
    /**
     * Set the project of the employee.
     * @param projects The manager ID to set.
     */
    public Long getProject() {
    return projectId;
     }
    /**
     * Set the manager of the employee.
     * @param manager The manager ID to set.
     */
    public String getManager() {
    return null;
     }
    /**
     * Returns a string representation of the Employee object.
     *
     * @return A string containing the values of the Employee's properties.
     */
    @Override
    public String toString() {
        return "Employee [Id=" + Id + ", empId=" + empId + ", name=" + name + ","
                + "email=" + email + ", dob=" + dob
                + ", doj=" + doj + ", location=" + location + ", designation="
                + designation + ", contactNumber="
                + contactNumber + ", role=" + role + ", projectId=" + projectId
                + ", password=" + password + ", skills="
                + skills + ", managerId=" + managerId + "]";
    }

    /**
     * Computes and returns a hash code value for the Employee object.
     * @return A hash code value based on the Employee's properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Id, contactNumber, designation, dob, doj,
                email, empId, location, managerId, name, password,
                projectId, role, skills);
    }

    /**
     * Indicates whether some other object is "equal to" this Employee.
     * @param obj The reference object with which to compare.
     * @return true if this Employee is the same as the obj argument.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return Objects.equals(Id, other.Id) && Objects.equals(contactNumber, other.contactNumber)
                && designation == other.designation
                && Objects.equals(dob, other.dob) && Objects.equals(doj, other.doj)
                && Objects.equals(email, other.email)
                && Objects.equals(empId, other.empId)
                && location == other.location
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(name, other.name)
                && Objects.equals(password, other.password)
                && Objects.equals(projectId, other.projectId) && role == other.role
                && Objects.equals(skills, other.skills);
    }

}
