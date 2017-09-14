package pizzamore.models.pages;

import pizzamore.models.cookie.Cookie;
import pizzamore.models.header.Header;
import pizzamore.models.session.Session;
import pizzamore.models.user.User;
import pizzamore.repository.SessionRepository;
import pizzamore.repository.UserRepository;
import pizzamore.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;


public class SignIn {

    private static final String SIGN_IN_HTML_FILE = "C:\\Apache24\\htdocs\\html\\signip.html";

    private static Map<String, String> parameters;
    private static Map<String, Cookie> cookies;
    private static Header header;
    private static UserRepository userRepository;
    private static SessionRepository sessionRepository;

    static {
        parameters = new HashMap<>();
        cookies = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
        sessionRepository = new SessionRepository();
    }

    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        readHtml();
    }

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        for (String param : parameters.keySet()) {
            switch (param) {
                case "signin":
                    signIn();
                    break;
                case "main":
                    goToMain();
                    break;
            }
        }
    }

    private static void signIn() {
        String username = parameters.get("username");
        String password = parameters.get("password");
        User user = UserRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            Session session = new Session();
            session.addData("username", username);
            long sid = SessionRepository.createSession(session);
            Cookie sessionCookie = new Cookie("sid", String.valueOf(sid));
            header.addCookie(sessionCookie);
            Cookie rememberMeCookie = new Cookie("remember-me", "on");
            header.addCookie(rememberMeCookie);
            header.setLocation("home.cgi");
        }
    }

    private static void goToMain() {
        header.setLocation("home.cgi");
    }

    private static void readHtml() {
        String html = WebUtils.readWholeFile(SIGN_IN_HTML_FILE);
        System.out.println(html);
    }
}
