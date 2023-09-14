package com.portal.DTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Emp Name Dto.
 */
@Getter
@Setter

public class UserDTO {
    /**
     * String Name.
     */
    private String name;
    /**
     * EmpNameDTO.
     * @param names emp name
     * @return
     */
    public UserDTO(final String names) {
        this.name = names;
        return;
    }
}
