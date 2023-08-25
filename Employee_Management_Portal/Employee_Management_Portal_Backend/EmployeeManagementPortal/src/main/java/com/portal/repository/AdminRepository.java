package com.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.portal.entities.Admin;

@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin,Long> {

//	 Admin findByEmail(String email);
	 Optional<Admin> findByEmail(String email) ;
}
