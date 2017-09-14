package httpProtocol.greetings;


import utils.WebUtils;

import java.util.Map;

public class LastNameForm {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\last-name-form.html";
    public static final String DATA_FILE = "C:\\Apache24\\htdocs\\others\\greetings.txt";

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
        String firstName = params.get("first-name");
        WebUtils.writeToFile(DATA_FILE, firstName, true);
    }
}
