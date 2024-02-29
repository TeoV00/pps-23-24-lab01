package tdd2;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import tdd.CircularListImpl;
import tdd.CircularListSimple;

public class CircularListIteratorImpl implements CircularListIterator {
    
    private CircularListSimple list = new CircularListImpl();

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<Optional<Integer>> forwardIterator() {
        return makeIterator((l) -> l.next());
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return makeIterator((l) -> l.previous());
    }

    private Iterator<Optional<Integer>> makeIterator(Function<CircularListSimple, Optional<Integer>> nextStrategy) {

        return new Iterator<Optional<Integer>>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Optional<Integer> next() {
                return nextStrategy.apply(list);
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
