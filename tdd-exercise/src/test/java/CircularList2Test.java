import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd2.CircularListIterator;
import tdd2.CircularListIteratorImpl;

public class CircularList2Test {

    private CircularListIterator circularListIterator;

    @BeforeEach
    void beforeEach() {
        this.circularListIterator = new CircularListIteratorImpl();
    }

    @Test
    void testAddElementsToList() {
        this.circularListIterator.add(1);
        this.circularListIterator.add(2);
        this.circularListIterator.add(3);
        assertEquals(3, circularListIterator.size());
    }

    @Test
    void testForwardIteratorCircularity() {
        this.circularListIterator.add(1);
        this.circularListIterator.add(2);
        Iterator<Optional<Integer>> forwardIterator = this.circularListIterator.forwardIterator();
        forwardIterator.next();
        forwardIterator.next();
        assertEquals(Optional.of(1), forwardIterator.next());
    }

    @Test
    void testBackwardIteratorCircularity() {
        this.circularListIterator.add(1);
        this.circularListIterator.add(2);
        Iterator<Optional<Integer>> backwardIterator = this.circularListIterator.backwardIterator();
        backwardIterator.next();
        assertEquals(Optional.of(2), backwardIterator.next());
    }

    @Test
    void testForwardIteratorWithEmptyList() {
        Iterator<Optional<Integer>> forwardIterator = this.circularListIterator.forwardIterator();
        forwardIterator.next();
        assertEquals(Optional.empty(), forwardIterator.next());
    }

    @Test
    void testBackwardIteratorWithEmptyList() {
        Iterator<Optional<Integer>> backwardIterator = this.circularListIterator.backwardIterator();
        backwardIterator.next();
        assertEquals(Optional.empty(), backwardIterator.next());
    }

}
