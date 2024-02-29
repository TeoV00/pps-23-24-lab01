import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularListImpl;
import tdd.CircularListSimple;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularListSimple circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    void testEmptyListSize() {
        assertEquals(0, circularList.size());
    }

    @Test
    void testIfListInitiallyEmpty() {
        assertEquals(true, circularList.isEmpty());
    }

    @Test
    void testListIsEmptyAfterPopulation() {
        populateList(List.of(1,2,3,4));
        assertEquals(false, circularList.isEmpty());
    }

    @Test
    void testAddOneElement() {
        populateList(List.of(3));
        assertAll(
            ()-> assertEquals(Optional.of(3), circularList.next()),
            () -> assertEquals(1, circularList.size())
        );
    }

    @Test
    void testMultipleAddElements() {
        List<Integer> expectedList = List.of(0,1,4);
        List<Integer> actuaList = new ArrayList<>();
        populateList(expectedList);

        for(int index = 0; index < circularList.size(); index++) {
            var nextElement = circularList.next();
            if (nextElement.isPresent()) {
                actuaList.add(nextElement.get());
            }
        }
        assertEquals(expectedList, actuaList);
    }

    @Test
    void testListIsCircularWithNext() {
        this.populateList(List.of(1,2));
        circularList.next();
        circularList.next();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testListIsCircularWithPrevious() {
        this.populateList(List.of(1,2));
        circularList.previous();
        assertEquals(Optional.of(2), circularList.previous());
    }

    @Test
    void testNextWithEmptyList() {
        int attemps = 4;
        for (int i = 0; i < attemps; i++) {
            circularList.next();
        }
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testPreviousWithEmptyList() {
        int attemps = 4;
        for (int i = 0; i < attemps; i++) {
            circularList.previous();
        }
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    void testResetListPosition() {
        populateList(List.of(1,2,3));
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
    }

    private void populateList(List<Integer> listElements) {
        listElements.forEach(element -> circularList.add(element));
    }
}
