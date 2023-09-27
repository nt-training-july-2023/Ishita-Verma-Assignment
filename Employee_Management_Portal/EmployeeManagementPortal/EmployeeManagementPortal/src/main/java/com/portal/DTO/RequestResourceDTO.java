package com.portal.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestResourceDTO {
	    
	    @NotBlank(message = "Comment Required")
	    private String comment;
	    
	    @NotNull(message="Manager Id Required")
	    private Long managerId;
	    
	    @NotNull(message="Employee Id Required")
	    private Long employeeId;
	   
	    @NotNull(message="Project Id Required")
	    private Long projectId;

		/**
		 * @return the comment
		 */
		public String getComment() {
			return comment;
		}

		/**
		 * @param comment the comment to set
		 */
		public void setComment(String comment) {
			this.comment = comment;
		}

		/**
		 * @return the managerId
		 */
		public Long getManagerId() {
			return managerId;
		}

		/**
		 * @param managerId the managerId to set
		 */
		public void setManagerId(Long managerId) {
			this.managerId = managerId;
		}

		/**
		 * @return the employeeId
		 */
		public Long getEmployeeId() {
			return employeeId;
		}

		/**
		 * @param employeeId the employeeId to set
		 */
		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}

		/**
		 * @return the projectId
		 */
		public Long getProjectId() {
			return projectId;
		}

		/**
		 * @param projectId the projectId to set
		 */
		public void setProjectId(Long projectId) {
			this.projectId = projectId;
		}
	    
}
