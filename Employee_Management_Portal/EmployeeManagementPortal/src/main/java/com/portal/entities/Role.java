package com.portal.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Enumeration representing different roles for users in the application.
 */
@Getter
@Setter
public enum Role {

    /**
     * Administrator role.
     */
    ADMIN,

    /**
     * Manager role.
     */
    MANAGER,

    /**
     * Employee role.
     */
    EMPLOYEE
}

