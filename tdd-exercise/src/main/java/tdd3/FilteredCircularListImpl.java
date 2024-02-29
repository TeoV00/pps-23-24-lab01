package tdd3;

import java.util.Optional;
import java.util.function.Function;
import tdd.CircularListImpl;
import tdd.CircularListSimple;

public class FilteredCircularListImpl implements FilteredCircularList {

    private CircularListSimple circularList;

    public FilteredCircularListImpl() {
        this.circularList = new CircularListImpl();
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> filter) {
        for(int i = 0; i < this.circularList.size(); i++) {
            var nextElement = this.circularList.next();
            if(filter.apply(nextElement.get())) {
                return Optional.of(nextElement.get());
            }
        }
        return Optional.empty();
    }

    @Override
    public void add(int element) {
       this.circularList.add(element);
    }

    @Override
    public Optional<Integer> next() {
       return this.circularList.next();
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> previous() {
        return this.circularList.previous();
    }

    @Override
    public void reset() {
        this.circularList.reset();
    }
}
