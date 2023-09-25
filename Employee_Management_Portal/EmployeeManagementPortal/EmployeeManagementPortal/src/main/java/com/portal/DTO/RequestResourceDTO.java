package com.portal.DTO;

public class RequestResourceDTO {
	    
	    private String comment;
	    
	    private Long managerId;
	    
	    private Long empId;
	   
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
		public Long getEmpId() {
			return empId;
		}

		/**
		 * @param employeeId the employeeId to set
		 */
		public void setEmpId(Long empId) {
			this.empId = empId;
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
