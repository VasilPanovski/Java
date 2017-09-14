package pr5_GenericCountMethodString;

import java.util.List;

/**
 * Created by mm on 16.7.2016 г..
 */
public class Box<T extends Comparable<T>> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <T extends Comparable<T>> int getComparedElementsSize(List<Box<T>> elements, Box<T> element) {
        int counter = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getValue().compareTo(element.getValue()) > 0) {
                counter++;
            }
        }
        return counter;
    }
}
