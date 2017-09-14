import java.util.Scanner;

/**
 * Created by mm on 31.5.2016 г..
 */
public class Pr9_TextFilter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] bannedWords = scn.nextLine().trim().split(", ");
        String text = scn.nextLine();

        for (String bannedWord : bannedWords) {
            text = text.replaceAll(bannedWord, new String(new char[bannedWord.length()])).replace("\0", "*");
        }
        System.out.println(text);
    }
}
