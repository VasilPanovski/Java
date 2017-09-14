package httpProtocol.login;

import utils.WebUtils;

import java.util.Map;


public class SendEmail {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\send-email.html";
    public static final int MAX_SUBJECT_LENGTH = 100;

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
        String receiver = params.get("receiver");
        String subject = params.get("subject");
        System.out.println("<br/>");
        if (subject.length() > MAX_SUBJECT_LENGTH) {
            System.out.println("Subject can not be more than 100 symbols!");
            return;
        }
        if (receiver == null) {
            System.out.println("Invalid email!");
            return;
        }

        System.out.println(String.format("Message to %s is send.", receiver));
    }
}
