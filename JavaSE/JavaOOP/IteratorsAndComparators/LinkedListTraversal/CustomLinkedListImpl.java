package pr9_LinkedListTraversal;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mm on 25.7.2016 г..
 */
public class CustomLinkedListImpl<T> implements CustomLinkedList<T>, Iterable<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public CustomLinkedListImpl() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T element) {
        ListNode<T> newTail = new ListNode<>(element);
        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            this.tail.nextNode = newTail;
            this.tail = newTail;
        }

        this.size++;
    }

    public boolean remove(T element) {
        if (this.size == 0) {
            throw new RuntimeException("The list is empty!");
        }

        ListNode<T> currentNode = this.head;
        ListNode<T> prevNode = null;
        while (currentNode != null) {
            if (currentNode.getValue() == element) {
                if (currentNode == this.head && currentNode == this.tail) {
                    this.head = this.tail = null;
                } else if (currentNode == this.head) {
                    this.head = currentNode.getNextNode();
                } else if (currentNode == this.tail) {
                    this.tail = prevNode;
                } else {
                    prevNode.nextNode = currentNode.getNextNode();
                }

                this.size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            ListNode<T> currentNode = null;

            @Override
            public boolean hasNext() {
                return this.currentNode != tail;
            }

            @Override
            public T next() {
                if (this.currentNode == null) {
                    this.currentNode = head;
                    return this.currentNode.getValue();
                }

                if (currentNode.getNextNode() == null) {
                    throw new NoSuchElementException();
                }

                this.currentNode = this.currentNode.getNextNode();
                return currentNode.getValue();
            }
        };

        return iterator;
    }

    private class ListNode<T> {

        private T value;
        private ListNode<T> nextNode;
        private ListNode<T> prevNode;

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public ListNode<T> getNextNode() {
            return nextNode;
        }
    }
}
