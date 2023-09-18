package com.portal.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing an Admin.
 */
@Entity
@Table(name = "employee")
public class Employee {
    /**
     * Unique identifier for the admin.
     */
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

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
    private long projectId;
    /**
     * Password of the user.
     */
    @Column
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public long getProject() {
	    return projectId;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long id, String empId, String name, String email, String dob, String doj, Location location,
			Designation designation, String contactNumber, Role role, long projectId, String password, List<String> skills,
			Long managerId) {
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
		this.role = role;
		this.projectId = projectId;
		this.password = password;
		this.skills = skills;
		this.managerId = managerId;
	}
	public String getManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
