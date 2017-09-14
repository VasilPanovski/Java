package pr7_CustomList;

/**
 * Created by mm on 17.7.2016 г..
 */
public class Sort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public void sort(CustomList<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 1; j < elements.size(); j++) {
                if (elements.getElement(j - 1).compareTo(elements.getElement(j)) > 0) {
                    elements.swap(j - 1, j);
                }
            }
        }
    }
}
