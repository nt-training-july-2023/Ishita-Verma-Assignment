package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing an Admin.
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
public class Admin {
    /**
     * Unique identifier for the admin.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;

    /**
     * Employee ID of the admin.
     */
    @Column(unique = true)
    private String empId;

    /**
     * Name of the admin.
     */
    @Column
    private String name;

    /**
     * Email address of the admin.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Date of birth of the admin.
     */
    @Column
    private String dob;

    /**
     * Date of joining of the admin.
     */
    @Column
    private String doj;

    /**
     * Location where the admin is based.
     */
    @Enumerated(EnumType.STRING)
    private Location location;

    /**
     * Designation of the admin.
     */
    @Enumerated(EnumType.STRING)
    private Designation designation;

    /**
     * Contact number of the admin.
     */
    @Column
    private long contactNumber;
    
    @Column
    private Role role;

    /**
     * Password of the admin.
     */
    @Column
    private String password;

    /**
     * Confirm password of the admin.
     */
    @Column
    private String confirmPassword;
    
    

}
