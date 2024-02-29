package tdd3;

import java.util.Optional;
import java.util.function.Function;

import tdd.CircularList;

public interface FilteredCircularList extends CircularList{

    Optional<Integer> filteredNext(Function<Integer, Boolean> filter);

}
