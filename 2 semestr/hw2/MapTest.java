package hw2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class MapTest {
    MyMap<String, Integer> mock = new MyMap<>();

    @BeforeEach
    public void setUp() {
        mock.put("Cowboy Bebop", 123);
        mock.put("One Punch Man", 1);
        mock.put("Berserk", 52);
    }

    @AfterEach
    void tearDown() {
        mock = new MyMap<>();
    }

    @Test
    void testPut() {
        mock.put("Baki", 1001);
        assertNotNull(mock);
        assertNotNull(mock.get("Baki"));
        assertTrue(mock.containsKey("Baki"));
    }

    @Test
    void testGet(){
        assertNotNull(mock.get("Cowboy Bebop"));
        assertEquals(mock.get("Cowboy Bebop"), 123);
    }

    @Test
    void testRemove() {
        mock.remove("One Punch Man");
        assertNull(mock.get("One Punch Man"));
    }

    @Test
    void testContainsKey() {
        assertTrue(mock.containsKey("Cowboy Bebop"));
        assertFalse(mock.containsKey("One Peace"));
    }

    @Test
    void testContainsValue() {
        assertTrue(mock.containsValue(1));
        assertFalse(mock.containsValue(0));
    }
}