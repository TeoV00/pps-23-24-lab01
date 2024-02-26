package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final int NEXT_INDEX_INCREMENT = 1;
    private final int PREVIOUS_INDEX_DECREMENT = -1;
    private List<Integer> list;
    private int listIndex = FIRST_ELEMENT_INDEX;

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
        Optional<Integer> element = getCurrentElement();
        incrementListIndex();
        return element;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> element = getCurrentElement();
        decrementListIndex();
        return element;
    }

    @Override
    public void reset() {
        this.listIndex = FIRST_ELEMENT_INDEX;
    }

    private Optional<Integer> getCurrentElement() {
        return !isEmpty() ? Optional.of(this.list.get(this.listIndex)) : Optional.empty();
    }

    private void incrementListIndex() {
        this.listIndex = this.listIndex + NEXT_INDEX_INCREMENT < this.size() ? this.listIndex + NEXT_INDEX_INCREMENT : 0;
    }

    private void decrementListIndex() {
        this.listIndex = this.listIndex - PREVIOUS_INDEX_DECREMENT >= 0 ? this.listIndex - PREVIOUS_INDEX_DECREMENT: this.size()-1;
    }
}
