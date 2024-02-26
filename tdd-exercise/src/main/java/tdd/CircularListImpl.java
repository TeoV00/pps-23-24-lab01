package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final int NEXT_INDEX_INCREMENT = 1;
    private final int PREVIOUS_INDEX_DECREMENT = -1;
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
       return this.size() <= 0;
    }

    @Override
    public Optional<Integer> next() {
        if (!isEmpty()) {
            Integer element = this.list.get(this.listIndex);
            incrementListIndex();
            return Optional.of(element);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (!isEmpty()) {
        Integer element = this.list.get(this.listIndex);
        decrementListIndex();
        return Optional.of(element);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    private void incrementListIndex() {
        this.listIndex = this.listIndex + NEXT_INDEX_INCREMENT < this.size() ? this.listIndex + NEXT_INDEX_INCREMENT : 0;
    }

    private void decrementListIndex() {
        this.listIndex = this.listIndex - PREVIOUS_INDEX_DECREMENT >= 0 ? this.listIndex - PREVIOUS_INDEX_DECREMENT: this.size()-1;
    }
}
