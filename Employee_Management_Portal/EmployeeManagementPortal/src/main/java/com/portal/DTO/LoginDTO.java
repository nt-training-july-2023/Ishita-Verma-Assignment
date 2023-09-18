package com.portal.DTO;

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
    
}
