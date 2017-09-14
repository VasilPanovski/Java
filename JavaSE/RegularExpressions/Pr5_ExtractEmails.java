import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 3.6.2016 г..
 */
public class Pr5_ExtractEmails {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9]+[_.\\-]?[a-zA-Z0-9]+@[a-zA-Z0-9]+[.\\-\\w]*[a-z{2,3}]\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
