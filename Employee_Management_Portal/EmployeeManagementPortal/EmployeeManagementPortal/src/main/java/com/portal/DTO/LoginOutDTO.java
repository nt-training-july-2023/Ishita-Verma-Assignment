package com.portal.DTO;

import java.util.Objects;

import com.portal.entities.Role;
/**
 * The LoginOutDTO class represents the data transfer object for login/logout responses.
 * It contains information such as the user's message, role, name, and ID.
 */
public class LoginOutDTO {
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
/**
 * Calculates the hash code value for this LoginOutDTO object.
 *
 * @return The hash code value based on the ID, message, name, and role.
 */
@Override
public int hashCode() {
    return Objects.hash(id, message, name, role);
}

/**
 * Indicates whether some other object is "equal to" this LoginOutDTO.
 *
 * @param obj The reference object with which to compare.
 * @return {@code true} if this LoginOutDTO is the same as the obj argument; {@code false} otherwise.
 */
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    LoginOutDTO other = (LoginOutDTO) obj;
    return Objects.equals(id, other.id) && Objects.equals(message, other.message)
            && Objects.equals(name, other.name) && role == other.role;
}

/**
 * Returns a string representation of this LoginOutDTO.
 *
 * @return A string containing the message, role, name, and ID of this LoginOutDTO.
 */
@Override
public String toString() {
    return "LoginOutDTO [message=" + message + ", role=" + role + ", name=" + name + ", id=" + id + "]";
}

 
}
