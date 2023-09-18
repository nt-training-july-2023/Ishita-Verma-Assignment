package com.portal.entities;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
    
   /**.
    * project id auto generated
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    /**.
     * project name
     */
    @Column(unique = true)
    private String name;
    /**.
     * project's manager id
     */
    @Column
    private Long managerId;
    /**.
     * start date of project
     */
    @Column
    private String startDate;
    /**.
     * list of skills required for project
     */
    @Column
    private List<String> skills;
     /**.
      * project description
      */
    @Column
    private String description;
	/**
	 * @return the projectId
	 */
	public long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(long projectId) {
		this.projectId = projectId;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the skills
	 */
	public List<String> getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param projectId
	 * @param name
	 * @param managerId
	 * @param startDate
	 * @param skills
	 * @param description
	 */
	public Project(long projectId, String name, Long managerId, String startDate, List<String> skills,
			String description) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.managerId = managerId;
		this.startDate = startDate;
		this.skills = skills;
		this.description = description;
	}
	/**
	 * 
	 */
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, managerId, name, projectId, skills, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(description, other.description) && Objects.equals(managerId, other.managerId)
				&& Objects.equals(name, other.name) && projectId == other.projectId
				&& Objects.equals(skills, other.skills) && Objects.equals(startDate, other.startDate);
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", managerId=" + managerId + ", startDate="
				+ startDate + ", skills=" + skills + ", description=" + description + "]";
	}
	 
   
}