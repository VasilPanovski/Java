import java.util.*;

/**
 * Created by mm on 31.5.2016 г..
 */
public class Pr11_Palindromes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        TreeSet<String> palindromes = new TreeSet<>();

        String text = scn.nextLine();
        String[] words = text.trim().split("[\\s+.,?!]+");

        for (String word : words) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromes.add(word);
            }

        }
        System.out.println(palindromes);
    }
}
