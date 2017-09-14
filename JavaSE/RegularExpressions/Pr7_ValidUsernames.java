import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 3.6.2016 г..
 */
public class Pr7_ValidUsernames {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine().trim();
        String[] splitedInput = input.split("[\\\\\\/() ]");

        ArrayList<String> usernames = new ArrayList<>();
        for (String validUser : splitedInput) {
            Pattern pattern = Pattern.compile("\\b[a-zA-z][a-zA-z0-9_]{2,25}+\\b");
            Matcher matcher = pattern.matcher(validUser);
            while (matcher.find()) {
                usernames.add(matcher.group());
            }
        }

        int sum = 0;
        int maxSum = 0;
        int bestIndex = 0;
        for (int i = 0; i < usernames.size() - 1; i++) {
            sum = usernames.get(i).length() + usernames.get(i + 1).length();
            if (sum > maxSum) {
                maxSum = sum;
                bestIndex = i;
            }
        }

        System.out.println(usernames.get(bestIndex));
        System.out.println(usernames.get(bestIndex + 1));
    }
}
