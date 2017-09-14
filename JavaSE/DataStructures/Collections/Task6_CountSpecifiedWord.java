import java.util.Scanner;


public class Task6_CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] text = input.nextLine().split(("\\W+"));
        String word = input.nextLine();

        int wordCounter = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i].equalsIgnoreCase(word)){
                wordCounter++;
            }
        }
        System.out.println(wordCounter);
    }
}
