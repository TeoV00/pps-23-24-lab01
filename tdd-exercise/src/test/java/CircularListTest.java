import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    void testAddOneElement() {
        circularList.add(3);
        assertAll(
            ()-> assertEquals(Optional.of(3), circularList.next()),
            () -> assertEquals(1, circularList.size())
        );
    }

    @Test
    void testMultipleAddElements() {
        List<Integer> expectedList = List.of(0,1,4);
        List<Integer> actuaList = new ArrayList<>();
        expectedList.forEach(e -> circularList.add(e));

        for(int index = 0; index < circularList.size(); index++) {
            var nextElement = circularList.next();
            if (nextElement.isPresent()) {
                actuaList.add(nextElement.get());
            }
        }
        assertEquals(expectedList, actuaList);
    }
}
