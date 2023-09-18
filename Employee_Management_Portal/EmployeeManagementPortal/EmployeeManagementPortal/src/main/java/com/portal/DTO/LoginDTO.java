package com.portal.DTO;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing login credentials.
 */

public class LoginDTO {
    /**
     * The email address associated with the user's account.
     */
    private String email;

    /**
     * The password provided by the user for authentication.
     */
    private String password;

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
    
}