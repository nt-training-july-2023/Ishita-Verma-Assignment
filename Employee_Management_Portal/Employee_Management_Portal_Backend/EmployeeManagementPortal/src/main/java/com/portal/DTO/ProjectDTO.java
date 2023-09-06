package com.portal.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {
	
	private int projectId;
	
	private String name;

	private String description;
	
	private String managerId;
	
	private List<String> skills;
	
	private String startDate;
}
