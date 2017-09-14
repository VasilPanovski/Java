package com.webFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BrowseCakes {

    public static final String HTML_FILE = "C:\\Apache24\\htdocs\\html\\browse-cakes.html";
    public static final String DATABASE_FILE = "C:\\Apache24\\htdocs\\others\\database.csv";

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
        String data = WebUtils.readWholeFile(DATABASE_FILE);
        String searchedCake = params.get("searchedWord");
        String[] tokens = data.split("[\\n]");
        List<String> tokensAsList = Arrays.asList(tokens);

        if (params.get("searchedWord") != null) {
            if (searchedCake == null || !data.contains(searchedCake)) {
                System.out.println("There is no such cake!");
            } else {
                for (String token : tokensAsList) {
                    String[] pairs = token.split(",");
                    String name = pairs[0];
                    String price = pairs[1];
                    System.out.println("Name: " + name + " Price: " + price + "<br/>");
                }
            }
        }
    }
}