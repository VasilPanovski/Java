import java.util.*;
import java.util.function.Predicate;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr10_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        scn.nextLine();
        int[] inputNumbers = Arrays.stream(scn.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> numbers = new HashSet<>();
        for (int inputNumber : inputNumbers) {
            numbers.add(inputNumber);
        }

        List<Predicate<Integer>> predicates = new ArrayList<>();
        for (Integer number : numbers) {
            Predicate<Integer> predicate = x -> x % number == 0;
            predicates.add(predicate);
        }

        boolean isDivisibleByAllNumbers = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < predicates.size(); j++) {
                if (!predicates.get(j).test(i)) {
                    isDivisibleByAllNumbers = false;
                }
            }
            if (isDivisibleByAllNumbers) {
                System.out.print(i + " ");
            }
            isDivisibleByAllNumbers = true;
        }
    }
}
