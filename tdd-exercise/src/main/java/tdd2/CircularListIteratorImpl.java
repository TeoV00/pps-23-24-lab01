package tdd2;

import java.util.ArrayList;
import java.util.List;

public class CircularListIteratorImpl implements CircularListIterator {
    private List<Integer> list = new ArrayList<>();
    @Override
    public void add(int element) {
        list.add(element);
    }
    @Override
    public Integer size() {
        return this.list.size();
    }

}
