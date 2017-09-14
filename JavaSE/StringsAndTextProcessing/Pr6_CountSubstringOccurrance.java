import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr6_CountSubstringOccurrance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().toLowerCase();
        String pattern = sc.nextLine().toLowerCase();

        int count = 0;
        int index = 0;
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index++;
        }
        System.out.println(count);
    }
}
