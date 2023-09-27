package com.portal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class RequestResource {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ResourceId;
	 
	    @Column
	    private String comment;
	    
	    @Column(nullable = false)
	    private Long managerId;
	    
	    @Column(nullable = false)
	    private Long employeeId;
	    
	    @Column(nullable = false)
	    private Long projectId;
		/**
		 * @return the resourceId
		 */
		public Long getResourceId() {
			return ResourceId;
		}
		/**
		 * @param resourceId the resourceId to set
		 */
		public void setResourceId(Long resourceId) {
			ResourceId = resourceId;
		}
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
