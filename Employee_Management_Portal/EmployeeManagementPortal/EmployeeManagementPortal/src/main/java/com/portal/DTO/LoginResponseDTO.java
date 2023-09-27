package com.portal.DTO;

import com.portal.entities.Role;

public class LoginResponseDTO {
 private String message;
 private Role role;
 private String name;
 private Long id;
 
 /**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
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
public Role getRole() {
	return role;
}
/**
 * @param role the role to set
 */
public void setRole(Role role) {
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
 
}
