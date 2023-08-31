package com.portal.DTO;

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
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing admin registration information.
 */
@Data
@NoArgsConstructor
public class AdminDTO {

    /**
     * The unique ID of the admin.
     */
    private long adminId;

    /**
     * The employee ID of the admin.
     */
    @Pattern(regexp = "[Nn]\\d{4}",
    message = "Employee ID should be in pattern NXXXX or nXXXX")
    private String empId;

    /**
     * The name of the admin.
     */
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z]+$",
    message = "Name must contain alphabetic characters only")
    private String name;

    /**
     * The email address of the admin.
     */
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be in a valid format")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq\\.com$",
    message = "Email must be a company email (@nucleusteq.com)")
    private String email;

    /**
     * The date of birth of the admin.
     */
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{2}$",
    message = "DOB should have a pattern like dd/mm/yy")
    private String dob;

    /**
     * The date of joining of the admin.
     */
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{2}$",
    message = "DOJ should have a pattern like dd/mm/yy")
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
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{2}$",
    message = "DOB should have a pattern like dd/mm/yy")
    private long contactNumber;

    /**
     * The password for the admin's account.
     */
    @Size(min = 8, message = "Password should have at least 8 characters")
    @Pattern(regexp =
    "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~]).{8,}$",
    message = "Incorrect")
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
    
   final @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordsMatch() {
        return password.equals(confirmPassword);
    }
}
