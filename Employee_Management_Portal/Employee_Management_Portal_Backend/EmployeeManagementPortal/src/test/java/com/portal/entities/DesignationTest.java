package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DesignationTest {

    @Test
    public void testDesignationEnum() {
        assertEquals(Designation.Engineer, Designation.valueOf("Engineer"));
        assertEquals(Designation.Senior_Engineer, Designation.valueOf("Senior_Engineer"));
        assertEquals(Designation.Architect, Designation.valueOf("Architect"));
        assertEquals(Designation.Technical_Lead, Designation.valueOf("Technical_Lead"));
        assertEquals(Designation.Senior_Architect, Designation.valueOf("Senior_Architect"));
        assertEquals(Designation.Recruiter, Designation.valueOf("Recruiter"));
        assertEquals(Designation.Operation_Analyst, Designation.valueOf("Operation_Analyst"));
    }

    

    @Test
    public void testToString() {
        assertEquals("Engineer", Designation.Engineer.toString());
        assertEquals("Senior_Engineer", Designation.Senior_Engineer.toString());
        assertEquals("Architect", Designation.Architect.toString());
    }


    @Test
    public void testEquality() {
        assertEquals(Designation.Engineer, Designation.Engineer);
        assertNotEquals(Designation.Architect, Designation.Senior_Architect);
    }


    @Test
    public void testValues() {
        Designation[] values = Designation.values();
        assertNotNull(values);
        assertEquals(7, values.length);
    }
    
    
}