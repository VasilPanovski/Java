import java.util.Scanner;

/**
 * Created by mm on 31.5.2016 г..
 */
public class Pr10_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String text = scn.nextLine();

        for (int i = 0; i < text.length(); i++) {
            String currentChar = "\\u00" + Integer.toHexString(text.charAt(i));
            System.out.print(currentChar);
        }

    }
}
