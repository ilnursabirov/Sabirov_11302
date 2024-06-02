package hw2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    MyList<Integer> mock = new MyList<>();

    @BeforeEach
    public void setUp(){
        mock.add(2);
        mock.add(17);
        mock.add(52);
        mock.add(110);
    }
    @AfterEach
    public void tearDown(){
        mock = new MyList<>();
    }

    @Test
    void testRemove() {
        mock.remove(2);
        assertEquals(mock.size(), 3);
        assertFalse(mock.contains(1));
    }
    @Test
    void testAdd() {
        mock.add(100);
        assertTrue(mock.contains(100));
        assertEquals(mock.get(3), 100);
    }
    @Test
    void testSize(){ assertEquals(3, mock.size()); }
    @Test
    void testGet() {
        assertEquals(mock.get(0), 1);
    }
    @Test
    void testContains() {
        assertTrue(mock.contains(1));
    }
}