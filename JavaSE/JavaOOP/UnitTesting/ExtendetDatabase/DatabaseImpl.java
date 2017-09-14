package pr2_ExtendetDatabase;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database {

    private List<User> users;

    public DatabaseImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void add(User user) throws OperationNotSupportedException {
        if (user == null) {
            throw new OperationNotSupportedException();
        }
        for (User currentUser : this.users) {
            if (currentUser.getId() == user.getId()) {
                throw new OperationNotSupportedException();
            }
        }

        this.users.add(user);
    }

    @Override
    public boolean remove(User user) throws OperationNotSupportedException {
        return this.users.remove(user);
    }

    @Override
    public User findById(Long id) throws OperationNotSupportedException {
        for (User user : this.users) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new OperationNotSupportedException();
    }

    @Override
    public User findByUserName(String userName) throws OperationNotSupportedException {
        if (userName == null) {
            throw new OperationNotSupportedException();
        }

        for (User user : this.users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }

        throw new OperationNotSupportedException();
    }

    public User getUser(int index) {
        return this.users.get(index);
    }

    public List<User> getUsers() {
        return this.users;
    }
}
