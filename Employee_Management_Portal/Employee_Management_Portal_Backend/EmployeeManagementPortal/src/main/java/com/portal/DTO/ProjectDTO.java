//package com.portal.DTO;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import javax.validation.constraints.NotBlank;
///**
// * Data Transfer Object (DTO) representing project information.
// */
//public class ProjectDTO {
//    /**
//     * The unique ID of the project.
//     */
//    private long projectId;
//
//    /**
//     * The name of the project.
//     */
//    @NotBlank(message = "Name should not be empty")
//    private String name;
//
//    /**
//     * The description of the project.
//     */
//    private String description;
//
//    /**
//     * The manager ID of the project.
//     */
//    @NotBlank(message = "Manager ID should not be empty")
//    private String managerId;
//
//    /**
//     * The list of skills required for the project.
//     */
//    private List<String> skills;
//    public List<String> getSkills() {
//        return new ArrayList<>(skills);
//    }
//
//    public void setSkills(List<String> skills) {
//        this.skills = new ArrayList<>(skills);
//    }
//    /**
//     * The start date of the project in YYYY-MM-DD format.
//     */
//    @NotBlank(message = "Start Date should not be empty")
//    private String startDate;
//
//    public long getProjectId() {
//        return projectId;
//    }
//
//    public void setProjectId(long projectId) {
//        this.projectId = projectId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getManagerId() {
//        return managerId;
//    }
//
//    public void setManagerId(String managerId) {
//        this.managerId = managerId;
//    }
//
//    public String getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//    public ProjectDTO(long projectId,
//            @NotBlank(message = "Name should not be empty") String name,
//            String description,
//            @NotBlank(message = "Manager ID should not be empty") String managerId,
//            List<String> skills,
//            @NotBlank(message = "Start Date should not be empty") String startDate) {
//        super();
//        this.projectId = projectId;
//        this.name = name;
//        this.description = description;
//        this.managerId = managerId;
//        this.skills = skills;
//        this.startDate = startDate;
//    }
//
//    public ProjectDTO() {
//        super();
//    }
//
//    /**
//     * Overrides the equals method to compare ProjectDTO objects for equality.
//     *
//     * @param o The object to compare to this ProjectDTO.
//     * @return True if the objects are equal, false otherwise.
//     */
//    final @Override
//    public boolean equals(final Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        ProjectDTO that = (ProjectDTO) o;
//        return projectId == that.projectId
//                && Objects.equals(name, that.name)
//                && Objects.equals(description, that.description)
//                && Objects.equals(managerId, that.managerId)
//                && Objects.equals(skills, that.skills)
//                && Objects.equals(startDate, that.startDate);
//    }
//
//    /**
//     * Overrides hashCode method to generate hash code for ProjectDTO.
//     *
//     * @return The hash code for this ProjectDTO.
//     */
//    final @Override public int hashCode() {
//        return Objects.hash(projectId, name, description, managerId,
//                skills, startDate);
//    }
//
//    /**
//     * Overrides the toString method to provide a string representation of this
//     * ProjectDTO.
//     *
//     * @return A string representation of this ProjectDTO.
//     */
//    final @Override public String toString() {
//        return "ProjectDTO{" + "projectId=" + projectId + ", name='" + name
//                + '\'' + ", description='" + description + '\''
//                + ", managerId='" + managerId + '\'' + ", skills=" + skills
//                + ", startDate='" + startDate + '\'' + '}';
//    }
//}
