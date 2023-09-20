package com.portal.DTO;

import com.portal.entities.Role;

public class LoginResponseDTO {
 private String message;
 private String role;
 private String name;
/**
 * @return the message
 */
public String getMessage() {
	return message;
}
/**
 * @param message the message to set
 */
public void setMessage(String message) {
	this.message = message;
}
/**
 * @return the role
 */
public String getRole() {
	return role;
}
/**
 * @param role the role to set
 */
public void setRole(String role) {
	this.role = role;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @param message
 * @param role
 * @param name
 */
public LoginResponseDTO(String message, String role, String name) {
	super();
	this.message = message;
	this.role = role;
	this.name = name;
}
 
}
