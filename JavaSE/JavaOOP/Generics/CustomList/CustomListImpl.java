package pr7_CustomList;

import java.util.*;

/**
 * Created by mm on 16.7.2016 г..
 */
public class CustomListImpl<T extends Comparable<T>> implements CustomList<T>, Iterable<T> {
    private List<T> elements;

    public CustomListImpl() {
        this.elements = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public T remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    @Override
    public void swap(int index1, int index2) {
        Collections.swap(this.elements, index1, index2);
    }

    @Override
    public int countGreaterThat(T element) {
        int counter = 0;
        for (T t : elements) {
            if (t.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public T getMax() {
        return Collections.max(this.elements);
    }

    @Override
    public T getMin() {
        return Collections.min(this.elements);
    }

    @Override
    public T getElement(int index) {
        return this.elements.get(index);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (index < elements.size()) {
                    return true;
                }

                return false;
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };

        return iterator;
    }
}
