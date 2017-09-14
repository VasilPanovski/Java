import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mm on 26.5.2016 г..
 */
public class Pr1_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> numbers = new Stack<>();

        Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).forEach(el -> numbers.push(el));
        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
