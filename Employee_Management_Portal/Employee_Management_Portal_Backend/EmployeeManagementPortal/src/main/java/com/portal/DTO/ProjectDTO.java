package com.portal.DTO;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {

    private int projectId;

    @NotBlank(message = "Name should not be empty")
    @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
    private String name;

    @Size(max = 255, message = "Description should not exceed 255 characters")
    private String description;

    @NotBlank(message = "Manager ID should not be empty")
    @Pattern(regexp = "N\\d{4}$", message = "Manager ID should be in format 'NXXXX'")
    private String managerId;

    @Size(max = 255, message = "Skills should not exceed 255 characters")
    private List<String> skills;

    @NotBlank(message = "Start Date should not be empty")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Start Date should be in YYYY-MM-DD format")
    private String startDate;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDTO that = (ProjectDTO) o;
        return projectId == that.projectId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(skills, that.skills) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name, description, managerId, skills, startDate);
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", managerId='" + managerId + '\'' +
                ", skills=" + skills +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}