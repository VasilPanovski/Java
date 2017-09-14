package pr1_Database;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;


public class DatabaseImpl implements Database {

    private static final int CAPACITY = 16;

    private Integer[] items;
    private int size;

    public DatabaseImpl(Integer... integers) {
        this.items = new Integer[CAPACITY];
        this.setItems(integers);
        this.setSize(integers);

    }

    private void setItems(Integer... integers) {
        if (integers == null) {
            throw new NullPointerException( );
        }

        for (int i = 0; i < integers.length; i++) {
            this.items[i] = integers[i];
        }
    }


    private void setSize(Integer... integers) {
        this.size = integers.length;
    }

    @Override
    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        this.items[this.size++] = element;

    }

    @Override
    public Integer remove() {
        if (this.items == null) {
            throw new NullPointerException();
        }

        Integer elementToRemove = this.items[this.size - 1];

        Integer[] newItems = new Integer[this.items.length - 1];
        for (int i = 0; i < newItems.length; i++) {
            newItems[i] = this.items[i];
        }

        this.items = newItems;
        return elementToRemove;
    }

    @Override
    public Integer[] fetch() {
        return this.items;
    }

    @Override
    public int getSize() {
        return Arrays.stream(this.items).filter(i -> i != null).toArray().length;
    }
}
