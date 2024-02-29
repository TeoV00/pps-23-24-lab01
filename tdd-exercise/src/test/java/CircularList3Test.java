import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd3.FilteredCircularList;
import tdd3.FilteredCircularListImpl;

public class CircularList3Test {
    FilteredCircularList filteredCirculaList;

    @BeforeEach
    void beforeEach() {
        filteredCirculaList = new FilteredCircularListImpl();
    }

    @Test
    void testFilteredNextWithoutFiltering() {
        populateList(List.of(4,5,1));
        filteredCirculaList.add(4);
        filteredCirculaList.add(5);
        filteredCirculaList.add(1);

        assertEquals(Optional.of(4), filteredCirculaList.filteredNext(e -> true));
    }

    @Test
    void testFilteredNextAfterNext() {
        populateList(List.of(1,2,3,9,4,5,6));
        filteredCirculaList.next();
        filteredCirculaList.next();
        assertEquals(Optional.of(4), filteredCirculaList.filteredNext((e)-> isEven(e)));
    }

    private void populateList(List<Integer> listElements) {
        listElements.forEach(element -> filteredCirculaList.add(element));
    }

    private Boolean isEven(Integer element) {
        return element%2 == 0;
    }

}
