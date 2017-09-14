import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 2.6.2016 г..
 */
public class Pr8_ExtractHyperlink {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String regex = "<a[^>]+href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]*))[^>]*>";
        StringBuilder text = new StringBuilder();

        String currentLine;
        while (!"END".equals(currentLine = scn.nextLine())) {
            text.append(currentLine);
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.toString());

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println(matcher.group(1));
            } else if (matcher.group(2) != null) {
                System.out.println(matcher.group(2));
            } else if (matcher.group(3) != null) {
                System.out.println(matcher.group(3));
            }
        }
    }
}
