import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    void testEmptyListSize() {
        assertEquals(0, circularList.size());
    }

    @Test
    void testIsEmpty() {
        assertEquals(true, circularList.isEmpty());
    }


}
