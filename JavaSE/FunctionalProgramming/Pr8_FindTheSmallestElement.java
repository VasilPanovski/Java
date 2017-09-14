import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr8_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] numbers = Arrays.stream(scn.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getMinNumAtRightmostPos.apply(numbers));
    }
    private static Function<int[], Integer> getMinNumAtRightmostPos = new Function<int[], Integer>() {
        @Override
        public Integer apply(int[] numbers) {
            int rightmostPos = numbers.length - 1;
            int minNum = numbers[numbers.length - 1];
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] < minNum) {
                    minNum = numbers[i];
                    rightmostPos = i;
                }
            }
            return rightmostPos;
        }
    };
}
