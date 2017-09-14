package pr2_ExtendetDatabase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class TestUserDatabase {


    Database database;

    @Before
    public void initialize() {
        this.database = new DatabaseImpl();
    }

    @Test
    public void testAddUserShouldWorkCorrectly() throws OperationNotSupportedException {
        String expected = "Pesho, 111222";
        database.add(new User("Pesho", 111222L));
        String actual = database.getUser(0).toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveUserFromListShouldWorkCorrectly() throws OperationNotSupportedException {
        User userToRemove = new User("Sasho", 333L);
        database.add(userToRemove);
        database.add(new User("Sashka", 666L));
        String expected = "Sashka, 666";
        database.remove(userToRemove);

        String actual = "";
        for (User user : database.getUsers()) {
            actual += user.toString();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findUserByItIdShouldReturnTheUser() throws OperationNotSupportedException{
        database.add(new User("Ivan", 50L));
        database.add(new User("Ivancho", 20L));


        String expected = "Ivancho, 20";
        String actual = "";
        for (User user : database.getUsers()) {
            if (database.findById(20L) == user) {
                actual += user.toString();
            }
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findUserByItNameShouldReturnTheUser() throws OperationNotSupportedException {
        database.add(new User("Lili", 18L));
        database.add(new User("Penka", 80L));

        String expected = "Lili, 18";
        String actual = "";
        for (User user : database.getUsers()) {
            if (database.findByUserName("Lili") == user) {
                actual += user.toString();
            }
        }

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfUserToFindDoesNotExistInDatabase() throws OperationNotSupportedException {
        database.add(new User("M", 10L));
        database.add(new User("N", 20L));
        database.add(new User("O", 30L));

        for (User user : database.getUsers()) {
            if (!(database.findByUserName("T") == user)) {
                throw new OperationNotSupportedException();
            }
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameMethodWithNullParameter() throws OperationNotSupportedException {
        database.add(new User("Tinka", 10L));
        database.add(new User("Minka", 10L));

        for (User user : database.getUsers()) {
            database.findByUserName(null);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMethodWithNullParameter() throws OperationNotSupportedException {
        database.add(new User("T", 100L));
        database.add(new User("M", 1000L));

        for (User user : database.getUsers()) {
            database.findById(null);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddUserWithExistingIdShouldThrowsException() throws OperationNotSupportedException {
        User userToAdd = new User("A", 1L);
        database.add(new User("A", 1L));
        database.add(new User("B", 2L));
        database.add(userToAdd);
    }
}
