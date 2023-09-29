package com.portal.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProjectOutDTO {
	   /**
     * project id.
     */
    private Long projectId;
    /**
     * name of project.
     */
    private String projectName;
    /**
     * project manager id.
     */
    private String manager;
    /**
     * manager id.
     */
    private Long managerId;
    /**
     * project start date.
     */
    private String startDate;
    /**
     * list of project skills.
     */
    private List<String> skills;
    /**
     * project description.
     */
    private String description;
    /**
     * list of teams.
     */
    private List<String> teams;
    /**
     * @return list of employee skills
     */public final List<String> getSkills() {
         return Collections.unmodifiableList(skills);
     }
     /**
      * @return list of employee teams
      */
     public final List<String> getTeams() {
         return Collections.unmodifiableList(teams);
     }
     /**
      * @return the projectId
      */
     public final Long getProjectId() {
         return projectId;
     }

     /**
      * @param projectID the projectId to set
      */
     public final void setProjectId(final Long projectId) {
         this.projectId = projectId;
     }
     /**
      * @return the projectName
      */
     public final String getProjectName() {
         return projectName;
     }
     /**
      * @param projectNames the projectName to set
      */
     public final void setProjectName(final String projectName) {
         this.projectName = projectName;
     }
     /**
      * @return the manager
      */
     public final String getManager() {
         return manager;
     }
     /**
      * @param managers the manager to set
      */
     public final void setManager(final String manager) {
         this.manager = manager;
     }
     /**
      * @return the managerId
      */
     public final Long getManagerId() {
         return managerId;
     }
     /**
      * @param managerID the managerId to set
      */
     public final void setManagerId(final Long managerId) {
         this.managerId = managerId;
     }
     /**
      * @return the startDate
      */
     public final String getStartDate() {
         return startDate;
     }
     /**
      * @param startDates the startDate to set
      */
     public final void setStartDate(final String startDates) {
         this.startDate = startDates;
     }
     /**
      * @return the descrption
      */
     public final String getDescription() {
         return description;
     }
     /**
      * @param description the descrption to set
      */
     public final void setDescription(final String description) {
         this.description = description;
     }
     /**
      * @param newSkills setting skills for employee
      */
     public final void setSkills(final List<String> newSkills) {
         if (newSkills != null) {
             this.skills = new ArrayList<>(newSkills);
         } else {
             this.skills = null;
         }
     }
     /**
      * @param team setting teams
      */
     public final void setTeams(final List<String> team) {
         if (team != null) {
             this.teams = new ArrayList<>(team);
         } else {
             this.teams = null;
         }
     }
     /**
      * Returns a string representation of this ProjectOutDTO.
      * @return A string containing the projectId, projectName, manager, managerId, startDate, skills, description, and teams of this ProjectOutDTO.
      */
     @Override
     public String toString() {
         return "ProjectOutDTO [projectId=" + projectId + ", projectName=" + projectName + ", manager=" + manager
                 + ", managerId=" + managerId + ", startDate=" + startDate + ", skills=" + skills + ", description="
                 + description + ", teams=" + teams + "]";
     }

     /**
      * Calculates the hash code value for this ProjectOutDTO object.
      * @return The hash code value based on the description, manager, managerId, projectId, projectName, skills, startDate, and teams.
      */
     @Override
     public int hashCode() {
         return Objects.hash(description, manager, managerId, projectId, projectName, skills, startDate, teams);
     }

     /**
      * Indicates whether some other object is "equal to" this ProjectOutDTO.
      * @param obj The reference object with which to compare.
      * @return {@code true} if this ProjectOutDTO is the same as the obj argument; {@code false} otherwise.
      */
     @Override
     public boolean equals(Object obj) {
         if (this == obj)
             return true;
         if (obj == null)
             return false;
         if (getClass() != obj.getClass())
             return false;
         ProjectOutDTO other = (ProjectOutDTO) obj;
         return Objects.equals(description, other.description) && Objects.equals(manager, other.manager)
                 && Objects.equals(managerId, other.managerId) && Objects.equals(projectId, other.projectId)
                 && Objects.equals(projectName, other.projectName) && Objects.equals(skills, other.skills)
                 && Objects.equals(startDate, other.startDate) && Objects.equals(teams, other.teams);
     }
  
}
