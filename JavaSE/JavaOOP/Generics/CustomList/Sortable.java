package pr7_CustomList;

/**
 * Created by mm on 17.7.2016 г..
 */
public interface Sortable<T extends Comparable<T>> {

    void sort(CustomList<T> elements);
}
