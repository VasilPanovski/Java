package com.webFundamentals;

public class ByTheCake {

    private static final String FILE = "C:\\Apache24\\htdocs\\html\\by-the-cake.html";

    public static void main(String[] args) {

        setContent();
        printHtml();

    }

    private static void setContent() {
        String type = "Content-Type: text/html \n";
        System.out.println(type);
    }

    private static void printHtml() {
        String html = WebUtils.readWholeFile(FILE);
        System.out.println(html);
    }
}
