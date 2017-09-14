import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1_StuckNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int givenNumbers = Integer.parseInt(input.nextLine());
        String[] numbers = input.nextLine().split(" ");

        String a, b, c, d;
        boolean hasStuckNumbers = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    for (int l = k + 1; l < numbers.length; l++) {
                        a = numbers[i];
                        b = numbers[j];
                        c = numbers[k];
                        d = numbers[l];

                        if (a != b && a != c && a != d && b != c && b != d && c != d) {
                            printEqualsStr(a, b, c, d);
                            printEqualsStr(a, b, d, c);
                            printEqualsStr(a, c, b, d);
                            printEqualsStr(a, c, d, b);
                            printEqualsStr(a, d, b, c);
                            printEqualsStr(a, d, c, b);
                            printEqualsStr(b, a, c, d);
                            printEqualsStr(b, a, d, c);
                            printEqualsStr(b, c, a, d);
                            printEqualsStr(b, c, d, a);
                            printEqualsStr(b, d, a, c);
                            printEqualsStr(b, d, c, a);
                            printEqualsStr(c, a, b, d);
                            printEqualsStr(c, a, d, b);
                            printEqualsStr(c, b, a, d);
                            printEqualsStr(c, b, d, a);
                            printEqualsStr(c, d, a, b);
                            printEqualsStr(c, d, b, a);
                            printEqualsStr(d, a, b, c);
                            printEqualsStr(d, a, c, b);
                            printEqualsStr(d, b, a, c);
                            printEqualsStr(d, b, c, a);
                            printEqualsStr(d, c, a, b);
                            printEqualsStr(d, c, b, a);
                            hasStuckNumbers = true;
                        }
                    }
                }
            }
        }
        if (!hasStuckNumbers) {
            System.out.println("No");
        }
    }

    private static void printEqualsStr (String a, String b, String c, String d) {
        if ((a + b).equals(c + d)) {
            System.out.printf("%s|%s==%s|%s\n", a, b, c, d);
        }
    }
}
