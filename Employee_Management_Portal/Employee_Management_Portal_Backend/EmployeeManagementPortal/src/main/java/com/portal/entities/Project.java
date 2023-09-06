package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable = false)
	private String managerId;
	
	@Column
	private String startDate;
	
	@Column
	private String skills;
	
	@Column
	private String description;

}
