import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] names = scn.nextLine().split("\\s+");
        Consumer<String> printNameWithPrefix = name -> System.out.printf("Sir %s%n", name);

        for (String name : names) {
            printNameWithPrefix.accept(name);
        }
    }
}
