package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class Admin {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long adminId; 

	    @Column(nullable = false)  
	    private String empId;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false, unique = true)  
	    private String email;

	    @Column
	    private String dob; 

	    @Column
	    private String doj; 

	    @Column
	    private String location;

	    @Column
	    private String designation;

	    @Column
	    private long contactNumber; 
	    
	    @Column(nullable = false)
	    private String password;

	    @Column(nullable = false)
	    private String confirmPassword;
}
