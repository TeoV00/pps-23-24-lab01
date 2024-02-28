import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tdd2.CircularListIterator;
import tdd2.CircularListIteratorImpl;

public class CircularList2Test {

    @Test
    void testCircularListIteratorCreation() {
        CircularListIterator circularListIterator = new CircularListIteratorImpl();
    }

    @Test
    void testAddElementsToList() {
        CircularListIterator circularListIterator = new CircularListIteratorImpl();
        circularListIterator.add(1);
        circularListIterator.add(2);
        circularListIterator.add(3);

        assertEquals(3, circularListIterator.size());
    }

}
