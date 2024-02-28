package tdd2;

import java.util.Iterator;
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
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }
            @Override
            public Integer next() {
                return list.next().get();
            }
        };
    }

}
