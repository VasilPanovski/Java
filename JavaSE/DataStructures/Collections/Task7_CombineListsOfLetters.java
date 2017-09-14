import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task7_CombineListsOfLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Character> firstList = new ArrayList<>();
        ArrayList<Character> secondList = new ArrayList<>();
        ArrayList<Character> combinedList = new ArrayList<>();

        for (char character : input.nextLine().toCharArray()) {
            firstList.add(character);
        }
        for (char character : input.nextLine().toCharArray()) {
            secondList.add(character);
        }

        combinedList.addAll(firstList);
        for (int i = 0; i < secondList.size(); i++) {
            if (!firstList.contains(secondList.get(i))) {
                combinedList.add(' ');
                combinedList.add(secondList.get(i));
            }
        }

        for (char character : combinedList) {
            System.out.print(character);
        }
    }
}
