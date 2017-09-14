package httpProtocol.greetings;


import utils.WebUtils;

public class FirstNameForm {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\first-name-form.html";

    public static void main(String[] args) {
        setContent();
        setHtml();
    }

    private static void setContent() {
        String type = "Content-Type: text/html\n";
        System.out.println(type);
    }

    private static void setHtml() {
        String html = WebUtils.readWholeFile(HTML_FILE);
        System.out.println(html);
    }
}
