package iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class GetExistingIterator {

    public static void main(String[] args) {
        //iterator
        List<Integer> numbers = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        boolean hasNext = iterator.hasNext();
        Integer number = iterator.next();

        //listerator
        List<Integer> integers = new ArrayList<>();
        ListIterator<Integer> listIterator = integers.listIterator();

        Integer previousElement = listIterator.previous();
        Integer nextElement = listIterator.next();
        hasNext = listIterator.hasNext();
        listIterator.add(10);
        listIterator.remove();
    }
}
