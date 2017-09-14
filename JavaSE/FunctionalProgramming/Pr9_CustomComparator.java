import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr9_CustomComparator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scn.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Comparator<Integer> customComparator = (x1, x2) -> {
            if (x1 % 2 == 0 && x2 % 2 != 0) {
                return -1;
            } else if (x1 % 2 != 0 && x2 % 2 == 0) {
                return 1;
            } else {
                if (x1 < x2) {
                    return -1;
                } else if (x1 > x2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

       Collections.sort(numbers, customComparator);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
