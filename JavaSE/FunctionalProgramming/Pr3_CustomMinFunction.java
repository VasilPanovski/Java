import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String inputLine = scn.nextLine();
        if (inputLine.equals("")) {
            System.out.println();
        }

        int[] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getMinNumber.apply(numbers));
    }

    private static Function<int[], Integer> getMinNumber = new Function<int[], Integer>() {
        @Override
        public Integer apply(int[] numbers) {
            int min = numbers[0];
            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        }
    };
}
