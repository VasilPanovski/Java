package httpProtocol.login;

import utils.WebUtils;

import java.util.Map;

public class ErrorChecker {

    public static final String USERNAME = "suAdmin";
    public static final String PASSWORD = "aDmInPw17";

    public static void main(String[] args) {
        boolean redirect = hasError();
        setContent(redirect);
    }

    private static boolean hasError() {
        Map<String, String> params = WebUtils.getParameters();
        String username = params.get("username");
        String password = params.get("password");

        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    private static void setContent(boolean redirect) {
        System.out.println("Content-Type: text/html");
        if (redirect) {
            System.out.println("Location: send-email.cgi?error=false");
        } else {
            System.out.println("Location: login.cgi?error=true");
        }
        System.out.println();
    }
}
