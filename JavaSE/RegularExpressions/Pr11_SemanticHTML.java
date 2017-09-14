import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mm on 3.6.2016 г..
 */
public class Pr11_SemanticHTML {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder semanticCode = new StringBuilder();
        Stack<String> values = new Stack<>();

        String currentLine;
        String currentValue = "";
        while (!"END".equals(currentLine = scn.nextLine())) {
            if (currentLine.contains("<div") && (currentLine.contains("id") ||
                    currentLine.contains("class"))) {
                String beforeTag = currentLine.substring(0, currentLine.indexOf("<div"));
                String beforeValue = currentLine.contains("class") ?
                        currentLine.substring(currentLine.indexOf("<div")+4, currentLine.indexOf("class")).replaceAll("\\s+", " ") :
                        currentLine.substring(currentLine.indexOf("<div")+4, currentLine.indexOf("id")).replaceAll("\\s+", " ");
                currentValue = getValue(currentLine.trim());
                values.push(currentValue);
                int index = currentLine.indexOf(currentValue) + currentValue.length() + 1;
                String afterValue = currentLine.substring(index).trim().replaceAll("\\s+", " ");

                semanticCode.append(beforeTag).append("<" + currentValue).append(beforeValue).append(afterValue + "\n");
                while (semanticCode.charAt(semanticCode.length() - 3) == ' ') {
                    semanticCode.deleteCharAt(semanticCode.length() - 3);
                }
            } else if (currentLine.contains("</div>")) {
                String beforeTag = currentLine.substring(0, currentLine.indexOf("<"));
                semanticCode.append(beforeTag);
                semanticCode.append(String.format("</%s>", values.pop())).append("\n");
            } else {
                semanticCode.append(currentLine);
                semanticCode.append("\n");
            }
        }
        System.out.println(semanticCode.toString());
    }

    private static String getValue(String currentLine) {
        String value = "";
        String[] tokens = currentLine.trim().split("\\s*=\\s*");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].contains("id") || tokens[i].contains("class")) {
                value = tokens[i+1].trim().substring(1, tokens[i+1].trim().indexOf("\"", 2));

            }
        }
        return value;
    }
}
