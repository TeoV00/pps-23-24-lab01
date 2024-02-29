package tdd2;

import java.util.Iterator;
import java.util.Optional;

public interface CircularListIterator {

    void add(int element);

    Integer size();

    Iterator<Optional<Integer>> forwardIterator();

    Iterator<Optional<Integer>> backwardIterator();

}
