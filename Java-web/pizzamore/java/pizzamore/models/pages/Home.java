package pizzamore.models.pages;


import pizzamore.models.cookie.Cookie;
import pizzamore.models.header.Header;
import pizzamore.models.session.Session;
import pizzamore.models.session.SessionData;
import pizzamore.repository.SessionRepository;
import pizzamore.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Home {

    private static final String HOME_HTML_FILE = "C:\\Apache24\\htdocs\\html\\home.html";

    private static Map<String, String> parameters;

    private static Map<String, Cookie> cookies;

    private static Header header;

    private static SessionRepository sessionRepository;

    static {
        parameters = new HashMap<>();
        cookies = new HashMap<>();
        header = new Header();
        sessionRepository = new SessionRepository();
    }

    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        readCookies(args);
        readHtml();
    }

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        for (String param : parameters.keySet()) {
            switch (param) {
                case "language":
                    String value = parameters.get("language");
                    setCookie("lang", value);
                    break;
                case "signin":
                    goToSignIn();
                    break;
                case "signup":
                    goToSignUp();
                    break;
            }
        }
    }

    private static void readCookies(String[] args) {
        if (args.length == 0) {
            return;
        }

        for (String incomingCookie : args) {
            String[] tokens = incomingCookie.split("=");
            String key = tokens[0];
            String value = tokens[1];
            value = value.replace(";", "");
            Cookie cookie = new Cookie(key, value);
            cookies.put(key, cookie);
        }
    }

    private static void readHtml() {
        Cookie sessionCookie = cookies.get("sid");
        String username = null;
        if (sessionCookie != null) {
            long sid = Long.valueOf(sessionCookie.getValue());
            Session session = sessionRepository.findById(sid);
            if (parameters.containsKey("signout")) {
                signOut(sid);
                session = null;
            }

            if (session != null) {
                Set<SessionData> sessionsData = session.getSessionData();
                for (SessionData sessionData : sessionsData) {
                    if (sessionData.getKey().equals("username")) {
                        username = sessionData.getValue();
                    }
                }
            }
        }

        String html = WebUtils.readWholeFile(HOME_HTML_FILE);
        Cookie languageCookie;
        if (!WebUtils.isPost()) {

            if (cookies.containsKey("lang")) {
                languageCookie = cookies.get("lang");
                if (languageCookie.getValue().equals("DE")) {
                    readHtmlDe(username, html);
                } else {
                    readHtmlEn(username, html);
                }
            }
        } else {
            if (parameters.containsKey("language")) {
                String language = parameters.get("language");
                if (language.equals("DE")) {
                    readHtmlDe(username, html);
                } else {
                    readHtmlEn(username, html);
                }
            }
        }
    }

    private static void signOut(long sid) {
        sessionRepository.deleteSession(sid);
    }


    private static void goToSignUp() {
        header.setLocation("signup.cgi");
    }

    private static void goToSignIn() {
        header.setLocation("signin.cgi");
    }

    private static void setCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        header.addCookie(cookie);
    }

    private static void readHtmlEn(String username, String html) {
        if (username != null) {
            html = html.replace("Sign In", "Sign Out(" + username + ")").replace("signin", "signout");
        }

        System.out.println(html);
    }

    private static void readHtmlDe(String username, String html) {
        html = html.replace("DE", "EN").replace("Sign Out", "Ausgänge").replace("Sign In", "Eingänge");
        if (username != null) {
            html = html.replace("Eingänge", "Ausgänge(" + username + ")");
        }

        System.out.println(html);
    }
}
