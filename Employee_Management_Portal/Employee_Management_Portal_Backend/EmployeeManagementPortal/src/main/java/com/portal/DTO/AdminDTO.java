package com.portal.DTO;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Data Transfer Object (DTO) representing admin registration information.
 */
@Getter
@Setter
@NoArgsConstructor
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

    private Role role;
    
    private String manager;
    
    private String managerId;
    
    private long projectId;

    private String project;

    private List<String> skills;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDTO = (AdminDTO) o;
        return Id == adminDTO.Id &&
                Objects.equals(empId, adminDTO.empId) &&
                Objects.equals(name, adminDTO.name) &&
                Objects.equals(email, adminDTO.email) &&
                Objects.equals(dob, adminDTO.dob) &&
                Objects.equals(doj, adminDTO.doj) &&
                Objects.equals(location, adminDTO.location) &&
                Objects.equals(designation, adminDTO.designation) &&
                Objects.equals(contactNumber, adminDTO.contactNumber) &&
                Objects.equals(password, adminDTO.password) &&
                role == adminDTO.role &&
                Objects.equals(manager, adminDTO.manager) &&
                Objects.equals(project, adminDTO.project) &&
                Objects.equals(skills, adminDTO.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, empId, name, email, dob, doj, location, designation, contactNumber, password, role, manager, project, skills);
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "Id=" + Id +
                ", empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", doj='" + doj + '\'' +
                ", location=" + location +
                ", designation=" + designation +
                ", contactNumber='" + contactNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", manager='" + manager + '\'' +
                ", Project='" + project + '\'' +
                ", skills=" + skills +
                '}';
    }
}
