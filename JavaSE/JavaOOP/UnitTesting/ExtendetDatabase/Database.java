package pr2_ExtendetDatabase;


import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface Database {

    void add(User user) throws OperationNotSupportedException;
    boolean remove(User user) throws OperationNotSupportedException;
    User findById(Long id) throws OperationNotSupportedException;
    User findByUserName(String userName) throws OperationNotSupportedException;
    User getUser(int index);
    List<User> getUsers();
}
