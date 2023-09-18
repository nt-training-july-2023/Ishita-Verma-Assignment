package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDTOTest {

	 private UserDTO user1;
	    private UserDTO user2;

	    @BeforeEach
	    public void setUp() {
	        user1 = new UserDTO("John");
	        user2 = new UserDTO("John");
	    }

	    @Test
	    public void testGetName() {
	        assertEquals("John", user1.getName());
	    }

	    @Test
	    public void testSetName() {
	        user1.setName("Alice");
	        assertEquals("Alice", user1.getName());
	    }

	    @Test
	    public void testHashCode() {
	        assertEquals(user1.hashCode(), user2.hashCode());
	    }

	    @Test
	    public void testEquals() {
	        // Test if user1 is equal to user2 (both have the same name)
	        assertEquals(user1, user2);
	        
	        // Create a new UserDTO object with a different name
	        UserDTO user3 = new UserDTO("Bob");
	        
	        // Test if user1 is not equal to user3 (different names)
	        assertNotEquals(user1, user3);
	    }

	    @Test
	    public void testToString() {
	        assertEquals("UserDTO [name=John]", user1.toString());
	    }
}
