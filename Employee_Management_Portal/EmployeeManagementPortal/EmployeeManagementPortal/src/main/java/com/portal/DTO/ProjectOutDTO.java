package com.portal.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectOutDTO {
	   /**
     * project id.
     */
    private long projectId;
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
    private String descrption;
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
     public final long getProjectId() {
         return projectId;
     }

     /**
      * @param projectID the projectId to set
      */
     public final void setProjectId(final long projectId) {
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
     public final void setProjectName(final String projectNames) {
         this.projectName = projectNames;
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
     public final void setManager(final String managers) {
         this.manager = managers;
     }
     /**
      * @return the managerId
      */
     public final long getManagerId() {
         return managerId;
     }
     /**
      * @param managerID the managerId to set
      */
     public final void setManagerId(final long managerID) {
         this.managerId = managerID;
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
     public final String getDescrption() {
         return descrption;
     }
     /**
      * @param description the descrption to set
      */
     public final void setDescrption(final String description) {
         this.descrption = description;
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
}
