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
        this.circularList = new CircularListImpl();
    }

    @Test
    void testEmptyListSize() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    void testIfListInitiallyEmpty() {
        assertEquals(true, this.circularList.isEmpty());
    }

    @Test
    void testListIsEmptyAfterPopulation() {
        populateList(List.of(1,2,3,4));
        assertEquals(false, this.circularList.isEmpty());
    }

    @Test
    void testAddOneElement() {
        populateList(List.of(3));
        assertAll(
            ()-> assertEquals(Optional.of(3), this.circularList.next()),
            () -> assertEquals(1, this.circularList.size())
        );
    }

    @Test
    void testMultipleAddElements() {
        List<Integer> expectedList = List.of(0,1,4);
        List<Integer> actuaList = new ArrayList<>();
        populateList(expectedList);

        for(int index = 0; index < this.circularList.size(); index++) {
            var nextElement = this.circularList.next();
            if (nextElement.isPresent()) {
                actuaList.add(nextElement.get());
            }
        }
        assertEquals(expectedList, actuaList);
    }

    @Test
    void testListIsCircularWithNext() {
        this.populateList(List.of(1,2));
        this.circularList.next();
        this.circularList.next();
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    void testListIsCircularWithPrevious() {
        this.populateList(List.of(1,2));
        this.circularList.previous();
        assertEquals(Optional.of(2), this.circularList.previous());
    }

    @Test
    void testNextWithEmptyList() {
        int attemps = 4;
        for (int i = 0; i < attemps; i++) {
            this.circularList.next();
        }
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    void testPreviousWithEmptyList() {
        int attemps = 4;
        for (int i = 0; i < attemps; i++) {
            this.circularList.previous();
        }
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test
    void testResetListPosition() {
        populateList(List.of(1,2,3));
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(Optional.of(1), this.circularList.next());
    }

    private void populateList(List<Integer> listElements) {
        listElements.forEach(element -> this.circularList.add(element));
    }
}
