import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by mm on 7.6.2016 г..
 */
public class Pr1_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String[] names = input.split(" ");

        Consumer<String> printName = System.out::println;

        for (String name : names) {
            printName.accept(name);
        }
    }
}
