package com.portal.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.portal.entities.Employee;
import com.portal.entities.Role;

/**
 * Repository interface for handling Admin entities.
 */
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Employee, Long> {
    /**
     * Finds an admin by email.
     * @param email The email of the admin.
     * @return An Optional containing the admin with the specified email.
     */
    Optional<Employee> findByEmail(String email);
    /**
     * Find By EmpId.
     * @param empId empId
     * @return employee
     */
    Optional<Employee> findByEmpId(String empId);
    /**
     * Find By Role.
     * @param role Role
     * @return Admin
     */
     List<Employee> findByRole(Role role);
    /**
     * Checks if an admin exists with the given email.
     * @param email The email to check.
     * @return True if an admin with the email exists, false otherwise.
     */
//    boolean existsByEmail(String email);
    boolean existsByEmail(String email);
    /**
     * Checks if an admin exists with the given empId.
     * @param empId empID
     * @return truw if exist and false if not
     */
    boolean existsByEmpId(String empId);
    /**
     * Retrieves a list of employees who are assigned.
     * @param projectId The unique identifier of the project.
     * @return A list of employees assigned to the project.
     */
    List<Employee> findAllByProjectId(Long projectId);
    /**
     * Retrieves an employee based on their manager.
     * @param managerId The unique identifier of the manager.
     * @return An Optional containing employee with specified manager
     */
    Optional<Employee> findByManagerId(Long managerId);

}
