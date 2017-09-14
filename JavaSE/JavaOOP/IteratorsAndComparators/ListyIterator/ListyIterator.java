package pr1_ListyIterator.models;

import javax.naming.OperationNotSupportedException;

/**
 * Created by mm on 18.7.2016 г..
 */
public interface ListyIterator {

    boolean move();

    boolean hasNext();

    void print() throws OperationNotSupportedException;

    void printAll();
}
