package pr3_StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mm on 19.7.2016 г..
 */
public class CustomStack implements Stack, Iterable<Integer> {
    List<Integer> elements;

    public CustomStack(List<Integer> elements) {
        this.setElements(elements);
    }

    public CustomStack() {
        this.elements = new ArrayList<>();
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public void push(List<Integer> inputElements) {
        for (Integer inputElement : inputElements) {
            this.elements.add(inputElement);
        }
    }

    @Override
    public int pop() {
        int indexToRemove = this.elements.size() - 1;
        if (indexToRemove < 0) {
            throw new IllegalArgumentException("No elements");
        }

        return this.getElements().remove(indexToRemove);
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator = new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (index < elements.size()) {
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                return elements.get(index++);
            }
        };

        return iterator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j = elements.size() - 1; j >= 0; j--) {
                sb.append(elements.get(j)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
