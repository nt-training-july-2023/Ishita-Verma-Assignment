package com.portal.validations;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
/**
 * This is class for validation.
 */
@Component
public class Validation {

	/**
     * pattern to check data
     */
	private String pattern;
	
	  /**
     * @param data user data
     * @return boolean
     */
	//check for empty fields
	public final boolean validEmptyData(final String data) {
	    return data == null || data.isEmpty();
	}

	   /**
     * @param data user data
     * @return boolean
     */
	 public final boolean validCharacter(final String data) {
	        pattern = "^[A-Za-z]+$";
	        return Pattern.matches(pattern, data);
	    }
	 
	//valid employee id
	    /**
	     * @param empId user employee id
	     * @return boolean
	     */
	    public final boolean validEmpId(final String empId) {
	        pattern = "N\\d{4}$";
	        return Pattern.matches(pattern, empId);
	    }
	  //for email id
	    /**
	     * @param email user email
	     * @return boolean
	     */
	    public final boolean validEmail(final String email) {
	        pattern = ".*@nucleusteq\\.com$";
	        return Pattern.matches(pattern, email);
	    }

	//for data format\
	    /**
	     * @param date user date of birth/date of joining
	     * @return boolean
	     */
	    public final boolean validDate(final String date) {
	        pattern = "\\d{4}-\\d{2}-\\d{2}";
	        return Pattern.matches(pattern, date);
	    }


	    /**
	     * @param phoneNo phone no of user
	     * @return boolean value
	     */
	    public final boolean validContactNumber(final String contactNumber) {
	        pattern = "^[0-9]{10}$";
	        return Pattern.matches(pattern, contactNumber);
	    }

	//passsword
	    /**
	     * @param password user password
	     * @return boolean.
	     */
	    public final boolean validPassword(final String password) {
	        pattern = "^[a-zA-Z0-9]{8}+$";
	        return Pattern.matches(pattern, password);
	    }
	    // confirm password
	    /**
	     * @param confirmPassword confirm password of user
	     * @param password of user
	     * @return boolean
	     */
	    public final boolean validConfirmPassword(
	            final String confirmPassword, final String password) {
	        return (confirmPassword.equals(password));
	    }

		public boolean validEmptySkills(List<String> skills) {
			return skills == null || skills.isEmpty();
		}
}
