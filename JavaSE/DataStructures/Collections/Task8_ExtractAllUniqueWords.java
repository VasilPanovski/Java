import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task8_ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = input.nextLine().toLowerCase().split("\\W+");

        TreeSet<String> uniqueWords = new TreeSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        for (String word : uniqueWords) {
            System.out.print(word + " ");
        }
    }
}
