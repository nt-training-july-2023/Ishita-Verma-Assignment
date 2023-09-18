package com.portal.DTO;

import java.util.Objects;

/**
 * Emp Name Dto.
 */


public class UserDTO {
    /**
     * String Name.
     */
    private String name;
    
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
	 * Computes the hash code for this object based on its 'name' attribute.
	 * @return The computed hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * Comparison is based on the 'name' attribute.
	 *
	 * @param obj The reference object with which to compare.
	 * @return {@code true} if this object is the same as the 'obj' argument;
	 *         {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(name, other.name);
	}
	/**
	 * Returns a string representation of this UserDTO object.
	 * The string contains the name attribute.
	 * @return A string representation of the UserDTO.
	 */
	@Override
	public String toString() {
		return "UserDTO [name=" + name + "]";
	}

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
