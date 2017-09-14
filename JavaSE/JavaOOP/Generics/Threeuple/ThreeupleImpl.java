package pr11_Threeuple;

import pr10_Tuple.TupleImpl;


public class ThreeupleImpl<K, V, T extends Comparable<T>> extends TupleImpl<K, V> implements Threeuple<K, V, T> {
    private T element;

    public ThreeupleImpl(K kye, V value, T element) {
        super(kye, value);
        this.setElement(element);
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public T getElement() {
        return this.element;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", super.toString(), this.element);
    }
}
