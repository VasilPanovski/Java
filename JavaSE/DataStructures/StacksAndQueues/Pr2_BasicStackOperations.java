import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mm on 26.5.2016 г..
 */
public class Pr2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbersCount = sc.nextInt();
        int numbersToPop = sc.nextInt();
        int numberToCheck = sc.nextInt();
        sc.nextLine();

        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < numbersCount; i++) {
            numbers.push(sc.nextInt());
        }

        for (int i = 0; i < numbersToPop; i++) {
            numbers.pop();
        }

        if (numbers.isEmpty()){
            System.out.println("0");
        } else if (numbers.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            int minNumber = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number < minNumber) {
                    minNumber = number;
                }
            }
            System.out.println(minNumber);
        }
    }
}
