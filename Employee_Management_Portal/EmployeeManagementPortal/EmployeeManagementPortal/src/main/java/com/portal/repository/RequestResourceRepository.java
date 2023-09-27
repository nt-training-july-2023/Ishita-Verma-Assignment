package com.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.portal.entities.RequestResource;

@EnableJpaRepositories
public interface RequestResourceRepository extends JpaRepository<RequestResource,Long>{

	List<RequestResource> findByEmployeeId(Long id);
	/**
	 * Finding request based on employee id and manager id
	 * @param id employee id
	 * @param managerId manager id
	 * @return Optional of request resource.
	 */
	   Optional<RequestResource> findByEmployeeIdAndManagerId(Long id,Long managerId);
	  
}
