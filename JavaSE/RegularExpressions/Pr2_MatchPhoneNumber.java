import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 2.6.2016 г..
 */
public class Pr2_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(\\+359\\s+2\\s+\\d{3}\\s\\d{4}\\b)|(\\+359\\-2\\-\\d{3}\\-\\d{4}\\b)");

        String inputStr;
        while (!"end".equals(inputStr = scn.nextLine())) {
            Matcher matcher = pattern.matcher(inputStr);
            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(match);
            }
        }
    }
}
