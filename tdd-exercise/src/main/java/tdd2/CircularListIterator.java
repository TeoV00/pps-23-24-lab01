package tdd2;

import java.util.Iterator;

public interface CircularListIterator {

    void add(int element);

    Integer size();

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();

}
