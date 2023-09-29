package com.portal.DTO;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) representing login credentials.
 */

public class LoginInDTO {
    /**
     * The email address associated with the user's account.
     */
	@NotBlank(message="Email required for login")
    private String email;

    /**
     * The password provided by the user for authentication.
     */
	@NotBlank(message="Password Required")
    private String password;
	/**
	 * Gets the email of the user.
	 *
	 * @return The user's email.
	 */
	public String getEmail() {
	    return email;
	}

	/**
	 * Sets the email of the user.
	 *
	 * @param email The email to set for the user.
	 */
	public void setEmail(String email) {
	    this.email = email;
	}

	/**
	 * Gets the password of the user.
	 *
	 * @return The user's password.
	 */
	public String getPassword() {
	    return password;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password The password to set for the user.
	 */
	public void setPassword(String password) {
	    this.password = password;
	}

	/**
	 * Returns a hash code value for the LoginDTO object based on its email and password.
	 *
	 * @return The hash code value for this LoginDTO.
	 */
	@Override
	public int hashCode() {
	    return Objects.hash(email, password);
	}

	/**
	 * Indicates whether some other object is "equal to" this LoginDTO.
	 *
	 * @param obj The reference object with which to compare.
	 * @return true if this LoginDTO is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    LoginInDTO other = (LoginInDTO) obj;
	    return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	/**
	 * Returns a string representation of the LoginDTO object.
	 *
	 * @return A string representation of this LoginDTO.
	 */
	@Override
	public String toString() {
	    return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
}