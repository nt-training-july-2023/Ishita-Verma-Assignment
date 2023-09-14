package com.portal.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.portal.entities.Admin;
import com.portal.entities.Role;

/**
 * Repository interface for handling Admin entities.
 */
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, Long> {
    /**
     * Finds an admin by email.
     * @param email The email of the admin.
     * @return An Optional containing the admin with the specified email.
     */
    Optional<Admin> findByEmail(String email);
    /**
     * Find By EmpId.
     * @param empId empId
     * @return employee
     */
    Optional<Admin> findByEmpId(String empId);
    /**
     * Find By Role.
     * @param role Role
     * @return Admin
     */
    List<Admin> findByRole(Role role);
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
}
