import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd3.FilteredCircularList;
import tdd3.FilteredCircularListImpl;

public class CircularList3Test {
    FilteredCircularList filteredCircularList;

    @BeforeEach
    void beforeEach() {
        filteredCircularList = new FilteredCircularListImpl();
    }

    @Test
    void testFilteredNextWithoutFiltering() {
        populateList(List.of(4,5,1));

        assertEquals(Optional.of(4), filteredCircularList.filteredNext(e -> true));
    }

    @Test
    void testFilteredNextAfterNext() {
        populateList(List.of(1,2,3,9,4,5,6));
        filteredCircularList.next();
        filteredCircularList.next();
        assertEquals(Optional.of(4), filteredCircularList.filteredNext((e)-> isEven(e)));
    }

    @Test
    void testAfterNextWithEmptyListWithoutFilter() {
        filteredCircularList.next();
        assertEquals(Optional.empty(), filteredCircularList.filteredNext((e)-> true));
    }

    private void populateList(List<Integer> listElements) {
        listElements.forEach(element -> filteredCircularList.add(element));
    }

    private Boolean isEven(Integer element) {
        return element%2 == 0;
    }

}
