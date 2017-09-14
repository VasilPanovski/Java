import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mm on 31.5.2016 г..
 */
public class Pr13MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String firstStr = scn.next();
        String secondStr = scn.next();
        System.out.print(areExchangeable(firstStr, secondStr));
    }

    private static boolean areExchangeable(String firstString, String secondString) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < firstString.length(); i++) {
            set1.add(firstString.charAt(i));
        }
        for (int i = 0; i < secondString.length(); i++) {
            set2.add(secondString.charAt(i));
        }

        if (set1.size() == set2.size()) {
            return true;
        }
        return false;
    }

}

