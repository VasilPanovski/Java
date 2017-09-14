package pizzamore.models.pages;


import pizzamore.models.header.Header;
import pizzamore.models.user.User;
import pizzamore.repository.UserRepository;
import pizzamore.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

public class SignUp {

    private static final String SIGN_UP_HTML_FILE = "C:\\Apache24\\htdocs\\html\\signup.html";

    private static Map<String, String> parameters;
    private static Header header;
    private static UserRepository userRepository;

    static {
        parameters = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
    }

    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        printHtml();
    }

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        String username = null;
        String password = null;
        for (String param : parameters.keySet()) {
            switch (param) {
                case "username":
                    username = parameters.get("username");
                    break;
                case "password":
                    password = parameters.get("password");
                    break;
                case "signup":
                    if (username.isEmpty() || password.isEmpty()) {
                        return;
                    }

                    User user = new User(username, password);
                    createUser(user);
                    header.setLocation("signin.cgi");
                    break;
                case "main":
                    header.setLocation("home.cgi");
                    break;
            }
        }
    }

    public static void createUser(User user) {
        userRepository.createUser(user);
    }

    private static void printHtml() {
        String html = WebUtils.readWholeFile(SIGN_UP_HTML_FILE);
        System.out.println(html);
    }
}
