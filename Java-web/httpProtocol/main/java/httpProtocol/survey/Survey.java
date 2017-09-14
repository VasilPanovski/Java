package httpProtocol.survey;


import utils.WebUtils;

import java.util.Map;

public class Survey {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\survey.html";
    public static final String DATA_FILE = "C:\\Apache24\\htdocs\\others\\survey-results.csv";

    public static void main(String[] args) {
        setContent();
        setHtml();
        trySetDataToFile();
    }

    private static void setContent() {
        String type = "Content-Type: text/html\n";
        System.out.println(type);
    }

    private static void setHtml() {
        String html = WebUtils.readWholeFile(HTML_FILE);
        System.out.println(html);
    }

    private static void trySetDataToFile() {
        Map<String, String> params = WebUtils.getParameters();
        if (params.containsKey("send")) {
            writeToFile(params);
        }
    }

    private static void writeToFile(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (params.containsKey("send")) {
                String data = key + ":" + value;
                WebUtils.writeToFile(DATA_FILE, data, true);
            }
        }
    }
}
