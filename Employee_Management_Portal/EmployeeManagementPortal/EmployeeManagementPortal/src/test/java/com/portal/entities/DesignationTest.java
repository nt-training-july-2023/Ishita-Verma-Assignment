package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; 

class DesignationTest {

	@Test
    public void testEngineer() {
        assertEquals("Engineer", Designation.Engineer.toString());
    }

    @Test
    public void testSeniorEngineer() {
        assertEquals("Senior_Engineer", Designation.Senior_Engineer.toString());
    }

    @Test
    public void testArchitect() {
        assertEquals("Architect", Designation.Architect.toString());
    }

    @Test
    public void testTechnicalLead() {
        assertEquals("Technical_Lead", Designation.Technical_Lead.toString());
    }

    @Test
    public void testSeniorArchitect() {
        assertEquals("Senior_Architect", Designation.Senior_Architect.toString());
    }

    @Test
    public void testRecruiter() {
        assertEquals("Recruiter", Designation.Recruiter.toString());
    }

    @Test
    public void testOperationAnalyst() {
        assertEquals("Operation_Analyst", Designation.Operation_Analyst.toString());
    }

}
