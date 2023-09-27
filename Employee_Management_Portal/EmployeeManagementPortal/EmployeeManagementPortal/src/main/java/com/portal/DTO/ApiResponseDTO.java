package com.portal.DTO;

import java.util.Objects;

public class ApiResponseDTO {

	  private String message;

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

//	/**
//	 * @param message
//	 */
//	public ApiResponseDTO(String message) {
//		super();
//		this.message = message;
//	}

//	/**
//	 * 
//	 */
//	public ApiResponseDTO() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public int hashCode() {
		return Objects.hash(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiResponseDTO other = (ApiResponseDTO) obj;
		return Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "ApiResponseDTO [message=" + message + "]";
	}
	
}
