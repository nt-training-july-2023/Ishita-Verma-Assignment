package com.portal.DTO;

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

	/**
	 * @param message
	 */
	public ApiResponseDTO(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	public ApiResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
