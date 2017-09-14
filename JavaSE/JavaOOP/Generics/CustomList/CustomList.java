package pr7_CustomList;

/**
 * Created by mm on 16.7.2016 г..
 */
public interface CustomList<T extends Comparable<T>> {

    void add(T element);
   	T remove(int index);
   	boolean contains(T element);
   	void swap(int index1, int index2);
   	int countGreaterThat(T element);
   	T getMax();
   	T getMin();
    T getElement(int index);
    int size();

}
