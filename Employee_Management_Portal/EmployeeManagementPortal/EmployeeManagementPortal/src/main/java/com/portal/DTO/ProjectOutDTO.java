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
     */
    public final List<String> getSkills() {
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
      * @param projectIdParam the projectId to set
      */
     public final void setProjectId(final Long projectIdParam) {
         this.projectId = projectIdParam;
     }
     /**
      * @return the projectName
      */
     public final String getProjectName() {
         return projectName;
     }
     /**
      * @param projectNameParam the projectName to set
      */
     public final void setProjectName(final String projectNameParam) {
         this.projectName = projectNameParam;
     }
     /**
      * @return the manager
      */
     public final String getManager() {
         return manager;
     }
     /**
      * @param managerParam the manager to set
      */
     public final void setManager(final String managerParam) {
         this.manager = managerParam;
     }
     /**
      * @return the managerId
      */
     public final Long getManagerId() {
         return managerId;
     }
     /**
      * @param managerIdParam the managerId to set
      */
     public final void setManagerId(final Long managerIdParam) {
         this.managerId = managerIdParam;
     }
     /**
      * @return the startDate
      */
     public final String getStartDate() {
         return startDate;
     }
     /**
      * @param startDatesParam the startDate to set
      */
     public final void setStartDate(final String startDatesParam) {
         this.startDate = startDatesParam;
     }
     /**
      * @return the description
      */
     public final String getDescription() {
         return description;
     }
     /**
      * @param descriptionParam the descrption to set
      */
     public final void setDescription(final String descriptionParam) {
         this.description = descriptionParam;
     }
     /**
      * @param newSkillsParam setting skills for employee
      */
     public final void setSkills(final List<String> newSkillsParam) {
         if (newSkillsParam != null) {
             this.skills = new ArrayList<>(newSkillsParam);
         } else {
             this.skills = null;
         }
     }
     /**
      * @param teamParam setting teams
      */
     public final void setTeams(final List<String> teamParam) {
         if (teamParam != null) {
             this.teams = new ArrayList<>(teamParam);
         } else {
             this.teams = null;
         }
     }
     /**
      * Returns a string representation of this ProjectOutDTO.
      * @return A string.
      */
     @Override
     public String toString() {
         return "ProjectOutDTO [projectId=" + projectId
                 + ", projectName=" + projectName + ", manager=" + manager
                 + ", managerId=" + managerId + ", startDate=" + startDate
                 + ", skills=" + skills + ", description="
                 + description + ", teams=" + teams + "]";
     }

     /**
      * Calculates the hash code value for this ProjectOutDTO object.
      * @return The hash code.
      */
     @Override
     public int hashCode() {
         return Objects.hash(description, manager,
                 managerId, projectId, projectName, skills, startDate, teams);
     }

     /**
      * Indicates whether some other object is "equal to" this ProjectOutDTO.
      * @param obj The reference object with which to compare.
      * @return {@code true} if this ProjectOutDTO is same as obj argument;
      * {@code false} otherwise.
      */
     @Override
     public boolean equals(final Object obj) {
         if (this == obj) {
             return true;
         }
         if (obj == null) {
             return false;
         }
         if (getClass() != obj.getClass()) {
             return false;
         }
         ProjectOutDTO other = (ProjectOutDTO) obj;
         return Objects.equals(description, other.description)
                 && Objects.equals(manager, other.manager)
                 && Objects.equals(managerId, other.managerId)
                 && Objects.equals(projectId, other.projectId)
                 && Objects.equals(projectName, other.projectName)
                 && Objects.equals(skills, other.skills)
                 && Objects.equals(startDate, other.startDate)
                 && Objects.equals(teams, other.teams);
     }
}
