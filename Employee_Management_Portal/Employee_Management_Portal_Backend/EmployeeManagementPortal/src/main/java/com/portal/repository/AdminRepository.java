package com.portal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.portal.entities.Admin;

/**
 * Repository interface for handling Admin entities.
 */
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, Long> {

    /**
     * Finds an admin by email.
     *
     * @param email The email of the admin.
     * @return An Optional containing the admin with the specified email.
     */
    Optional<Admin> findByEmail(String email);

    /**
     * Checks if an admin exists with the given email.
     *
     * @param email The email to check.
     * @return True if an admin with the email exists, false otherwise.
     */
    boolean existsByEmail(String email);
}
