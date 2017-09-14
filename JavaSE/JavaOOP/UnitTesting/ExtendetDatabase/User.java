package pr2_ExtendetDatabase;


import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private Long id;
    private List<Database> users;

    public User(String userName, Long id) {
        this.setUserName(userName);
        this.setId(id);
        this.users = new ArrayList<>();
    }

    private void setUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            try {
                throw new OperationNotSupportedException();
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }

        this.userName = userName;
    }

    private void setId(Long id) {
        if (id < 0 || id == null) {
            try {
                throw new OperationNotSupportedException();
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format(this.getUserName() + ", " + this.getId());
    }
}
