package com.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.portal.entities.RequestResource;

/**
 * JPA repository interface for managing {@link RequestResource} entities.
 * @see JpaRepository
 */
@EnableJpaRepositories
public interface RequestResourceRepository
        extends JpaRepository<RequestResource, Long> {
    /**
     * Retrieves a list of RequestResource entities
     * with employee by their employee ID.
     * @param id The ID of the employee for which
     * to retrieve associated request resources.
     * @return A list of RequestResource entities
     * associated with the specified employee.
     */
    List<RequestResource> findByEmployeeId(Long id);

    /**
     * Finding request based on employee id and manager id.
     * @param id employee id
     * @param managerId manager id
     * @return Optional of request resource.
     */
    Optional<RequestResource> findByEmployeeIdAndManagerId(Long id,
            Long managerId);

}
