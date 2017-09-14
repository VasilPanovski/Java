package pr11_Threeuple;

import pr10_Tuple.Tuple;

public interface Threeuple<K, V, T extends Comparable<T>> extends Tuple<K, V> {

    void setElement(T element);

    T getElement();
}
