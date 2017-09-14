import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 3.6.2016 г..
 */
public class Pr10_UseYorChainsBuddy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();

        Pattern pattern = Pattern.compile("<p>(.+?)<\\/p>");
        Matcher matcher = pattern.matcher(input);
        StringBuilder text = new StringBuilder();
        StringBuilder decryptedText = new StringBuilder();

        String currentTag;
        while (matcher.find()) {
            currentTag = matcher.group(1).replaceAll("[^a-z0-9]+", " ");
            text.append(currentTag);
        }
        String newText = text.toString().replaceAll("\\s+", " ");

        for (int i = 0; i < newText.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) < 'n') {
                decryptedText.append((char) (text.charAt(i) + 13));
            } else if (text.charAt(i) >= 'n' && text.charAt(i) <= 'z') {
                decryptedText.append((char)(text.charAt(i) - 13));
            } else {
                decryptedText.append(text.charAt(i));
            }
        }
        System.out.println(decryptedText.toString().replaceAll("\\s+", " "));
    }
}
