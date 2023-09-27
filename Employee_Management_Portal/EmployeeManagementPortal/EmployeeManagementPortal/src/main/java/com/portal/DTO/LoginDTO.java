package com.portal.DTO;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) representing login credentials.
 */

public class LoginDTO {
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

    public LoginDTO(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDTO other = (LoginDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}

	/**
	 * @param email
	 * @param password
	 */
	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 */
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
