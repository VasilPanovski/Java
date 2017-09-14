import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr6_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] numbers = Arrays.stream(scn.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = scn.nextInt();

        Predicate<Integer> isDivisibleByNum = num -> num % n == 0;

        int currentNum;
        for (int i = numbers.length - 1; i >= 0; i--) {
            currentNum = numbers[i];
            if (!isDivisibleByNum.test(currentNum)) {
                System.out.print(currentNum + " ");
            }
        }
    }
}
