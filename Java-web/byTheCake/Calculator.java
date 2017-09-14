package com.webFundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Calculator {

    private static final String FILE = "C:\\Apache24\\htdocs\\html\\calculator.html";
    private static final List<String> validSigns = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

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
        String html = WebUtils.readWholeFile(FILE);
        System.out.println(html);
    }

    private static void setResponse() {
        Map<String, String> params = WebUtils.getParameters();
        String firstNum = params.get("firstNumber");
        String secondNum = params.get("secondNumber");
        String sign = params.get("sign");
        boolean isValidNumbers = firstNum.matches("^\\d+$") && secondNum.matches("^\\d+$");
        if (params.get("firstNumber") != null && params.get("secondNumber") != null) {
            if (!validSigns.contains(params.get("sign"))) {
                System.out.println("<br/><span style=\"font-size: 30px\">Invalid Sign<span/>");
            } else if (!isValidNumbers) {
                System.out.println("<br/><span style=\"font-size: 30px\">Invalid numbers<span/>");
            } else {
                printResult(params);
            }
        }
    }

    private static void printResult(Map<String, String> params) {
        int firstNum = Integer.valueOf(params.get("firstNumber"));
        int secondNum = Integer.valueOf(params.get("secondNumber"));
        String sign = params.get("sign");
        System.out.print("<br/><span style=\"font-size: 30px\">Result: <span/>");
        switch (sign) {
            case "+":
                System.out.println(firstNum + secondNum);
                break;
            case "-":
                System.out.println(firstNum - secondNum);
                break;
            case "*":
                System.out.println(firstNum * secondNum);
                break;
            case "/":
                System.out.println(firstNum / secondNum);
                break;
            default:
                break;
        }
    }
}
