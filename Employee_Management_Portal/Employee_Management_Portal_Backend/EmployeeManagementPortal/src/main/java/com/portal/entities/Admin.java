package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity class representing an Admin.
 */
@Entity
@Table(name = "admin")
@Data
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
    @Column
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
    @Column
    private String location;

    /**
     * Designation of the admin.
     */
    @Column
    private String designation;

    /**
     * Contact number of the admin.
     */
    @Column
    private long contactNumber;

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
