package tdd2;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularListIteratorImpl implements CircularListIterator {
    private CircularList list = new CircularListImpl();

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public Integer size() {
        return this.list.size();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return makeIterator((l) -> l.next());
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return makeIterator((l) -> l.previous());
    }

    private Iterator<Integer> makeIterator(Function<CircularList, Optional<Integer>> nextStrategy) {

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                return nextStrategy.apply(list).get();
            }
        };
    }
}
