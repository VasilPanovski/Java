import java.util.Scanner;

public class CountSubstringOccurrence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String givenStr = input.nextLine();

        int counter = 0;
        for (int i = -1; (i = text.toLowerCase().indexOf(givenStr.toLowerCase(), i + 1)) != -1; ) {
            counter++;
        }
        System.out.println(counter);
    }
}
