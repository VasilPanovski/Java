import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr4_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int startRange = scn.nextInt();
        int endRange = scn.nextInt();
        scn.nextLine();
        String inputComand = scn.nextLine();

        Predicate<Integer> isEven = x -> inputComand.equals("even") ? x % 2 == 0 : x % 2 != 0;

        for (int i = startRange; i <= endRange; i++) {
            if (isEven.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
