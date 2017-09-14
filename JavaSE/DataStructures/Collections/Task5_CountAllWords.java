import java.util.Scanner;

public class Task5_CountAllWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] text = input.nextLine().split(("\\W+"));
        System.out.println(text.length);
    }
}
