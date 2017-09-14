import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr13_InfernoIII {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] gems = Arrays.stream(scn.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String inputLine = null;
        while (!"Forge".equals(inputLine = scn.nextLine())) {
            String[] tokens = inputLine.split(";");
            String command = tokens[0].trim();
            String filterType = tokens[1].trim();
            int parameter = Integer.parseInt(tokens[2].trim());

        }
    }
    private static Function<int[], Integer> markGems = new Function<int[], Integer>() {
        @Override
        public Integer apply(int[] ints) {

        }
    }
}
