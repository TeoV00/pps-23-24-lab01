import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd2.CircularListIterator;
import tdd2.CircularListIteratorImpl;

public class CircularList2Test {

    CircularListIterator circularListIterator;

    @BeforeEach
    void beforeEach() {
        this.circularListIterator = new CircularListIteratorImpl();
    }

    @Test
    void testAddElementsToList() {
        circularListIterator.add(1);
        circularListIterator.add(2);
        circularListIterator.add(3);

        assertEquals(3, circularListIterator.size());
    }

    @Test
    void testForwardIteratorCircularity() {
        circularListIterator.add(1);
        circularListIterator.add(2);
        Iterator<Optional<Integer>> forwardIterator = circularListIterator.forwardIterator();
        forwardIterator.next();
        forwardIterator.next();
        assertEquals(Optional.of(1), forwardIterator.next());
    }

    @Test
    void testBackwardIteratorCircularity() {
        circularListIterator.add(1);
        circularListIterator.add(2);
        Iterator<Optional<Integer>> backwardIterator = circularListIterator.backwardIterator();
        backwardIterator.next();
        assertEquals(Optional.of(2), backwardIterator.next());
    }

    @Test
    void testForwardIteratorWithEmptyList() {
        Iterator<Optional<Integer>> forwardIterator = circularListIterator.forwardIterator();
        forwardIterator.next();
        assertEquals(Optional.empty(), forwardIterator.next());
    }

    @Test
    void testBackwardIteratorWithEmptyList() {
        Iterator<Optional<Integer>> backwardIterator = circularListIterator.backwardIterator();
        backwardIterator.next();
        assertEquals(Optional.empty(), backwardIterator.next());
    }

}
