package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTest {

	
	 @Test
	    void testLocationEnum() {
	        assertEquals(Location.Raipur, Location.valueOf("Raipur"));
	        assertEquals(Location.Canada, Location.valueOf("Canada"));
	        assertEquals(Location.Bangalore, Location.valueOf("Bangalore"));
	        assertEquals(Location.Phoenix, Location.valueOf("Phoenix"));
	        assertEquals(Location.Indore, Location.valueOf("Indore"));
	       
	    }

	 @Test
	    void testEquality() {
	        assertEquals(Location.Raipur, Location.Raipur);
	        assertNotEquals(Location.Canada, Location.Indore);
	    }

	    @Test
	    void testToString() {
	        assertEquals("Raipur", Location.Raipur.toString());
	        assertEquals("Indore", Location.Indore.toString());
	        assertEquals("Canada", Location.Canada.toString());
	    }

	
	

}
