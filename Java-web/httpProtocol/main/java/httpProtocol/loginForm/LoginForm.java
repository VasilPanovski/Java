package httpProtocol.loginForm;

import utils.WebUtils;

import java.util.Map;

public class LoginForm {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\WebFundamentals\\html\\login-form.html";

    public static void main(String[] args) {
        setContent();
        setHtml();
        setResponse();
    }
    private static void setContent() {
        String type = "Content-Type: text/html \n";
        System.out.println(type);
    }

    private static void setHtml() {
        String html = WebUtils.readWholeFile(HTML_FILE);
        System.out.println(html);
    }

    private static void setResponse() {
        Map<String, String> params = WebUtils.getParameters();
        String username = params.get("username");
        String password = params.get("password");
        if (username != null && password != null) {
            System.out.println("<br/>");
            System.out.println(String.format("Hi %s, your password is %s", username, password));
        }
    }
}
