import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 2.6.2016 г..
 */
public class Pr1_MatchFullName {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+\\s+[A-Z][a-z]+\\b");
        String inputStr;
        while (!"end".equals(inputStr = scn.nextLine())) {
            Matcher matcher = pattern.matcher(inputStr);
            while (matcher.find()) {
                String match = matcher.group().replaceAll("\\s+", " ");
                System.out.println(match);
            }
        }
    }
}
