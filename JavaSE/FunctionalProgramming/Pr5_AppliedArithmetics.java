import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr5_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] numbers = Arrays.stream(scn.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<Integer, Integer> add = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        Function<Integer, Integer> subtract = x -> x - 1;

        String command;
        while (!"end".equals(command = scn.nextLine())) {
            for (int i = 0; i < numbers.length; i++) {
                int currentNum = numbers[i];
                if (command.equals("add")) {
                    numbers[i] = add.apply(currentNum);
                } else if (command.equals("multiply")) {
                    numbers[i] = multiply.apply(currentNum);
                } else if (command.equals("subtract")) {
                    numbers[i] = subtract.apply(currentNum);
                } else {
                    printResult(numbers);
                    break;
                }
            }
        }
    }

    private static void printResult(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
