package pr1_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class TestDatabase {

    @Test
    public void testConstructorShouldWorkCorrectly() {
        Integer expected = 10;
        Database database = new DatabaseImpl(expected);
        Integer actual = database.fetch()[0];

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testArrayCapacity() {
        Database database = new DatabaseImpl(1);

        int expectedCapacity = 16;
        int actualCapacity = database.getSize();

        Assert.assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testAddOperation() {
        Database database = new DatabaseImpl();
        Integer expected = 10;

        try {
            database.add(10);
        } catch (OperationNotSupportedException npe) {
            npe.printStackTrace();
        }
        Integer actual = database.fetch()[0];

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveOperationShouldReturnTheArrayWithoutLastElement()  {
        Database database = new DatabaseImpl(1, 2, 3);

        Integer expected = 3;
        Integer actual = null;
        try {
            actual = database.remove();
        } catch (OperationNotSupportedException one) {
            one.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArraySizeShouldReturnTheSizeOfTheArray() {
        Database database = new DatabaseImpl(2, 3, 4);
        int expected = 3;
        int actual = database.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementShouldThrowAnException() throws OperationNotSupportedException {
        Database database = new DatabaseImpl();

        database.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveElementFromEmptyArrayShouldThrowsAnException() {

        Database database = new DatabaseImpl(null);
    }
}
