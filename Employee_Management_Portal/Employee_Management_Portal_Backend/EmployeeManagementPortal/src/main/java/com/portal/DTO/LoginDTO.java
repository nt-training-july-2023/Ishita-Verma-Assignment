package com.portal.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing login credentials.
 */
@Getter
@Setter
public class LoginDTO {
    /**
     * The email address associated with the user's account.
     */
    private String email;

    /**
     * The password provided by the user for authentication.
     */
    private String password;
}
