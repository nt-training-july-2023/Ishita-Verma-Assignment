package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.entities.RequestResource;

@Repository
public interface RequestResourceRepository extends JpaRepository<RequestResource,Long>{

}
