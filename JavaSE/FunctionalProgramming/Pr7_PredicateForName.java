import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr7_PredicateForName {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nameLength = scn.nextInt();
        scn.nextLine();
        String[] names = scn.nextLine().split("\\s+");

        Predicate<String> isLessThanNamelength = name -> name.length() <= nameLength;
        for (String name : names) {
            if (isLessThanNamelength.test(name)) {
                System.out.println(name);
            }
        }
    }
}
