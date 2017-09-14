package com.webFundamentals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AddCake {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\add-cake.html";
    public static final String DATABASE_FILE = "C:\\Apache24\\htdocs\\others\\database.csv";

    public static void main(String[] args) {
        setContent();
        setHtml();
        setResponse();
    }

    private static void setContent() {
        String type = "Content-Type: text/html \n\n";
        System.out.println(type);
    }

    private static void setHtml() {
        String html = WebUtils.readWholeFile(HTML_FILE);
        System.out.println(html);
    }

    private static void setResponse() {
        Map<String, String> params = WebUtils.getParameters();
        addCakeToDatabase(params);
        if (params.get("cake") != null) {
            System.out.println("name: " + params.get("cake") + "<br/>");
            System.out.println("price: " + params.get("price"));
        }
    }

    private static void addCakeToDatabase(Map<String, String> cakeParams) {
        try(FileWriter writer = new FileWriter(DATABASE_FILE, true)) {
            writer.append(cakeParams.get("cake"));
            writer.append(",");
            writer.append(cakeParams.get("price"));
            writer.append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
