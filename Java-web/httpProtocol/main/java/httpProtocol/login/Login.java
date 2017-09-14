package httpProtocol.login;

import utils.WebUtils;

import java.util.Map;

public class Login {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\login.html";

    public static void main(String[] args) {
        setContent();
        setHtml();
        setResponse();
    }

    private static void setContent() {
        String type = "Content-Type: text/html\n";
        System.out.println(type);
    }

    private static void setHtml() {
        String html = WebUtils.readWholeFile(HTML_FILE);
        System.out.println(html);
    }

    private static void setResponse() {
        Map<String, String> params = WebUtils.getParameters();
        boolean hasError = params.get("error") != null;
        if (hasError) {
            System.out.println("<p style=\"color: red\">Invalid username or password!</p>");
        }
    }
}
