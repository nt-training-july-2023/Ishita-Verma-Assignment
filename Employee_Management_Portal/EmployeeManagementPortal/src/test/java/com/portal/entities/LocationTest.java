package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTest {
	@Test
    public void testLocationIndore() {
        Location location = Location.Indore;
        assertEquals("Indore", location.toString());
    }

    @Test
    public void testLocationRaipur() {
        Location location = Location.Raipur;
        assertEquals("Raipur", location.toString());
    }

    @Test
    public void testLocationBangalore() {
        Location location = Location.Bangalore;
        assertEquals("Bangalore", location.toString());
    }

    @Test
    public void testLocationPhoenix() {
        Location location = Location.Phoenix;
        assertEquals("Phoenix", location.toString());
    }

    @Test
    public void testLocationCanada() {
        Location location = Location.Canada;
        assertEquals("Canada", location.toString());
    }

}
