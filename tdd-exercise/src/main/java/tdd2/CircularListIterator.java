package tdd2;

import java.util.Iterator;
import java.util.Optional;

import tdd.CircularList;

public interface CircularListIterator extends CircularList {

    /**
     * 
     * @return
     */
    Iterator<Optional<Integer>> forwardIterator();

    /**
     * 
     * @return
     */
    Iterator<Optional<Integer>> backwardIterator();

}
