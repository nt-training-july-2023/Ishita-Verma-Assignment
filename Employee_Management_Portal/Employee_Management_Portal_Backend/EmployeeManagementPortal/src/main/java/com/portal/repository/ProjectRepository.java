//package com.portal.repository;
////
////import java.util.List;
////
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
////
////import com.portal.entities.Project;
////
/////**
//// * Repository interface for managing Project entities.
//// */
////@EnableJpaRepositories
////public interface ProjectRepository extends JpaRepository<Project, Long> {
////    /**
////     * Find projects by both project ID and manager ID.
////     * @param projectId The project ID to search for.
////     * @param managerId The manager ID to search for.
////     * @return A list of projects matching the given project ID and manager ID.
////     */
////    List<Project> findByProjectIdAndManagerId(long projectId,
////            String managerId);
////
////    /**
////     * Find a project by its name.
////     * @param projectName The name of the project to search for.
////     * @return The project with the specified name, if found.
////     */
////    Project findByName(String projectName);
////
////    /**
////     * Display project as per the manager.
////     * @param projectName The name of the project to search for.
////     * @return The project with the specified name, if found.
////     */
////    List<Project> findAllByManagerId(String managerId);
////}
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import com.portal.entities.Project;
///**
// * project repository.
// */
//@EnableJpaRepositories
//public interface ProjectRepository extends JpaRepository<Project, Long> {
//    /**
//     * findAllByManagerID.
//     * @param managerID manger empID
//     * @return List project
//     */
//    List<Project> findByManagerID(Long managerID);
//    /**
//     * findByProjectID.
//     * @param projectID project Id
//     * @return project
//     */
//    Optional<Project> findByProjectID(long projectID);
//}