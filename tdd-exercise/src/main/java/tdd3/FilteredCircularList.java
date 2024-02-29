package tdd3;

import java.util.Optional;
import java.util.function.Function;
import tdd.CircularListSimple;

public interface FilteredCircularList extends CircularListSimple {

    /**
     *  @param filter the filter used to search next element in circula list
     * @return Optional.empty() if no element of list satisfy filter condition, otherwise an optional with the first element found.
     * */
    Optional<Integer> filteredNext(Function<Integer, Boolean> filter);

}
