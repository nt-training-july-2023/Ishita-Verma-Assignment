package com.portal.DTO;
		
import java.util.List;
import java.util.Objects;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;
	
	public class EmployeeOutDTO {
		 /**
	     * .* Id of employee.
	     */
	    private long Id;
	    /**
	     * . employee id of employee.
	     */
	    
	    private String empId;
	    /**
	     * name of employee.
	     */
	   
	    private String name;
	    /**
	     * email id of employee.
	     */
	   
	    private String email;
	    /**
	     * date of birth of employee.
	     */
	    
	    private String dob;
	    /**
	     * date of joining of employee.
	     */
	
	    private String doj;
	    /**
	     * location of employee.
	     */
	    
	    private Location location;
	    /**
	     * designation of employee.
	     */
	   
	    private Designation designation;
	    /**
	     * contact number of employee.
	     */
	 
	    private String contactNumber;
	    /**
	     * role of employee.
	     */
	   
	    private Role role;
	    
	    /**
	     * projectId of employee.
	     */
	    private String projectId;
	    /**
	     * project name
	     */
	    private String projectName;
	    /**
	     * skills of employee.
	     */
	    private List<String> skills;
	    /**
	     * manager id of employee.
	     */
	    
	    private String manager;
	    /**
	     * manager of employee.
	     */
	    
	    private Long managerId;
		/**
		 * @return the id
		 */
		public long getId() {
			return Id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(long id) {
			Id = id;
		}
		/**
		 * @return the empId
		 */
		public String getEmpId() {
			return empId;
		}
		/**
		 * @param empId the empId to set
		 */
		public void setEmpId(String empId) {
			this.empId = empId;
		}
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
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the dob
		 */
		public String getDob() {
			return dob;
		}
		/**
		 * @param dob the dob to set
		 */
		public void setDob(String dob) {
			this.dob = dob;
		}
		/**
		 * @return the doj
		 */
		public String getDoj() {
			return doj;
		}
		/**
		 * @param doj the doj to set
		 */
		public void setDoj(String doj) {
			this.doj = doj;
		}
		/**
		 * @return the location
		 */
		public Location getLocation() {
			return location;
		}
		/**
		 * @param location the location to set
		 */
		public void setLocation(Location location) {
			this.location = location;
		}
		/**
		 * @return the designation
		 */
		public Designation getDesignation() {
			return designation;
		}
		/**
		 * @param designation the designation to set
		 */
		public void setDesignation(Designation designation) {
			this.designation = designation;
		}
		/**
		 * @return the contactNumber
		 */
		public String getContactNumber() {
			return contactNumber;
		}
		/**
		 * @param contactNumber the contactNumber to set
		 */
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		/**
		 * @return the role
		 */
		public Role getRole() {
			return role;
		}
		/**
		 * @param role the role to set
		 */
		public void setRole(Role role) {
			this.role = role;
		}
		/**
		 * @return the projectId
		 */
		public String getProjectId() {
			return projectId;
		}
		/**
		 * @param projectId the projectId to set
		 */
		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}
		/**
		 * @return the skills
		 */
		public List<String> getSkills() {
			return skills;
		}
		/**
		 * @param string the skills to set
		 */
		public void setSkills(List<String> string) {
			this.skills = string;
		}
		/**
		 * @return the manager
		 */
		public String getManager() {
		    return manager;
		}
		/**
		 * @param manager the manager to set
		 */
		public void setManager(String manager) {
			this.manager = manager;
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
		@Override
		public int hashCode() {
			return Objects.hash(Id, contactNumber, designation, dob, doj, email, empId, location, manager, managerId,
					name, projectId, role, skills);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EmployeeOutDTO other = (EmployeeOutDTO) obj;
			return Id == other.Id && Objects.equals(contactNumber, other.contactNumber)
					&& designation == other.designation && Objects.equals(dob, other.dob)
					&& Objects.equals(doj, other.doj) && Objects.equals(email, other.email)
					&& Objects.equals(empId, other.empId) && location == other.location
					&& Objects.equals(manager, other.manager) && Objects.equals(managerId, other.managerId)
					&& Objects.equals(name, other.name) && Objects.equals(projectId, other.projectId)
					&& role == other.role && Objects.equals(skills, other.skills);
		}
		@Override
		public String toString() {
			return "EmployeeOutDTO [Id=" + Id + ", empId=" + empId + ", name=" + name + ", email=" + email + ", dob="
					+ dob + ", doj=" + doj + ", location=" + location + ", designation=" + designation
					+ ", contactNumber=" + contactNumber + ", role=" + role + ", projectId=" + projectId + ", skills="
					+ skills + ", manager=" + manager + ", managerId=" + managerId + "]";
		}
		/**
		 * @param id
		 * @param empId
		 * @param name
		 * @param email
		 * @param dob
		 * @param doj
		 * @param location
		 * @param designation
		 * @param contactNumber
		 * @param role
		 * @param projectId
		 * @param skills
		 * @param manager
		 * @param managerId
		 */
		public EmployeeOutDTO(long id, String empId, String name, String email, String dob, String doj,
				Location location, Designation designation, String contactNumber, Role role, String projectId,
				List<String> skills, String manager, Long managerId) {
			super();
			Id = id;
			this.empId = empId;
			this.name = name;
			this.email = email;
			this.dob = dob;
			this.doj = doj;
			this.location = location;
			this.designation = designation;
			this.contactNumber = contactNumber;
			this.role = role;
			this.projectId = projectId;
			this.skills = skills;
			this.manager = manager;
			this.managerId = managerId;
		}
		/**
		 * 
		 */
		public EmployeeOutDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @return the projectName
		 */
		public String getProjectName() {
			return projectName;
		}
		/**
		 * @param projectName the projectName to set
		 */
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

	}