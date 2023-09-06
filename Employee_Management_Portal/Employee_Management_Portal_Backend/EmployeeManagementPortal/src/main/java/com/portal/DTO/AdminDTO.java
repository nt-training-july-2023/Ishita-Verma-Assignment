package com.portal.DTO;

import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
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
    private String empId;

    /**
     * The name of the admin.
     */
   private String name;

    /**
     * The email address of the admin.
     */
   private String email;

    /**
     * The date of birth of the admin.
     */
   private String dob;

    /**
     * The date of joining of the admin.
     */
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
    private String contactNumber;

    /**
     * The password for the admin's account.
     */
    private String password;

    /**
     * The confirmation password for the admin's account.
     */
    private String confirmPassword;
    /**
     * Password matching with confirm password field.
     * @return confirmPassword
     */
    
    private Role role;
    
    private String Project;
    
    private List<String> skills;
}
