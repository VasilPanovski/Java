package iterators;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Library implements Iterable<String> {

    private String[] booksName;
    private Iterator<String> currentIterator;

    public Library(String... booksName) {
        this.setBooksName(booksName);

    }

    private void setBooksName(String... booksName) {
        this.booksName = booksName;
    }

    @Override
    public Iterator<String> iterator() {
        return new LibraryIterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.currentIterator = new LibraryIterator();

        action.accept(this.currentIterator.next());
    }

    private class LibraryIterator implements Iterator<String> {

        private int index;

        private LibraryIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < booksName.length;
        }

        @Override
        public String next() {
            if (this.hasNext()) {
                return booksName[this.index++];
            }

            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        Library library = new Library("a", "b", "c");

        for (Iterator<String> iterator = library.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
