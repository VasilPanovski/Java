package pr1_ListyIterator.models;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.List;


public class ListyIteratorImpl<E> implements ListyIterator, Iterator<E>, Iterable<E> {
    List<E> elements;
    int currentIndex;

    public ListyIteratorImpl(List<E> elements) {
        this.setElements(elements);
        this.setCurrentIndex(0);
    }

    public List<E> getElements() {
        return elements;
    }

    public void setElements(List<E> elements) {
        if  (elements.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.elements = elements;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    public boolean hasNext() {
        if (this.getCurrentIndex() < this.getElements().size() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if (this.hasNext()) {
            return this.getElements().get(this.currentIndex++);
        }

        throw new IndexOutOfBoundsException("Index is out of range!");
    }

    @Override
    public boolean move() {
        if  (this.currentIndex + 1 < this.elements.size()) {
            this.currentIndex++;
            return true;
        }

        return false;
    }

    @Override
    public void print() throws OperationNotSupportedException {
        if (this.getElements().size() == 0) {
            throw new OperationNotSupportedException("The collection is empty!");
        }

        System.out.println(this.getElements().get(this.getCurrentIndex()));
    }

    @Override
    public void printAll() {
        if (this.elements.size() == 0) {
            throw new IllegalArgumentException("The collection is empty!");
        }

        for (E element : this) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return this.getElements().iterator();
    }
}
