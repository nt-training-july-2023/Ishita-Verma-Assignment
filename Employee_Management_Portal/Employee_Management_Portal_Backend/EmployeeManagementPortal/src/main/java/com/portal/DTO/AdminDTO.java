package com.portal.DTO;

import javax.persistence.Column;

import lombok.Data;

@Data

public class AdminDTO {

	private long adminId;

	private String empId;

	private String name;

	private String email;

	private String dob;

	private String doj;

	private String location;

	private String designation;

	private long contactNumber;

	private String password;

	private String confirmPassword;

}
