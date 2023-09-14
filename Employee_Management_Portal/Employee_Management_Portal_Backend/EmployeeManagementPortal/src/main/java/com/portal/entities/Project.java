//package com.portal.entities;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
////@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "projects")
//public class Project {
//    
//   /**.
//    * project id auto generated
//    */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long projectId;
//    /**.
//     * project name
//     */
//    @Column(unique = true)
//    private String name;
//    /**.
//     * project's manager id
//     */
//    @Column
//    private Long managerId;
//    /**.
//     * start date of project
//     */
//    @Column
//    private String startDate;
//    /**.
//     * list of skills required for project
//     */
//    @Column
//    private List<String> skills;
//     /**.
//      * project description
//      */
//    @Column
//    private String descrption;  
//    /**
//     * 
//     * @param projectId
//     * @param projectName
//     * @param managerId
//     * @param managerName
//     * @param skills
//     * @param descrption
//     */
//    public Project(long projectId, String projectName, Long managerId, String managerName, List<String> skills, String descrption) {
//        this.projectId = projectId;
//        this.name = projectName;
//        this.managerId = managerId;
//        this.skills = new ArrayList<>(skills);
//        this.descrption = descrption;
//    }
//}