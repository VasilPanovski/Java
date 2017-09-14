package pr9_LinkedListTraversal;

/**
 * Created by mm on 25.7.2016 г..
 */
public interface CustomLinkedList<T> extends Iterable<T> {
    void add(T element);
    boolean remove(T element);
    int getSize();
}
