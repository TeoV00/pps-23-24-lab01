package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private List<Integer> list;
    private int listIndex = 0;

    public CircularListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
       return this.list.size();
    }

    @Override
    public boolean isEmpty() {
       return true;
    }

    @Override
    public Optional<Integer> next() {
        Integer element = this.list.get(this.listIndex);
        nextElementIndex();
        return Optional.of(element);
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    private void nextElementIndex() {
        this.listIndex = this.listIndex + 1 < this.size() ? this.listIndex + 1 : 0;
    }
}
