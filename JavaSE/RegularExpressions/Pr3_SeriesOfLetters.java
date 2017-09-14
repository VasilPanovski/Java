import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 2.6.2016 г..
 */
public class Pr3_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();
        String regex = "(\\w)\\1+";
        String replacmentChars = "$1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String m = matcher.replaceAll(replacmentChars);
        System.out.println(m);
    }
}
