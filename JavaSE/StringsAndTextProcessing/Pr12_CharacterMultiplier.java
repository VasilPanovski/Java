import java.util.Scanner;

/**
 * Created by mm on 31.5.2016 г..
 */
public class Pr12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String firtstStr = scn.next();
        String secondStr = scn.next();

        long sum = 0;
        int minLength = Math.min(firtstStr.length(), secondStr.length());
        for (int i = 0; i < minLength; i++) {
            sum += firtstStr.charAt(i)*secondStr.charAt(i);
        }
        if (firtstStr.length() == secondStr.length()) {
            System.out.println(sum);
            return;
        }

        String largerStr = firtstStr.length() >= secondStr.length() ?  firtstStr : secondStr;
        largerStr = largerStr.substring(minLength);
        for (int i = 0; i < largerStr.length(); i++) {
            sum += largerStr.charAt(i);
        }
        System.out.println(sum);
    }
}
