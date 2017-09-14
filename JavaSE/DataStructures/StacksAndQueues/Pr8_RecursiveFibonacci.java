import java.util.Scanner;

/**
 * Created by mm on 29.5.2016 г..
 */
public class Pr8_RecursiveFibonacci {
    public static long[] fibNumbers;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        fibNumbers = new long[n + 2];
        fibNumbers[1] = 1;
        fibNumbers[2] = 1;

        long result = getFibonacciNumber(n+1);
        System.out.println(result);
    }

    private static long getFibonacciNumber(int n) {
        long counter = 0;
        if (fibNumbers[n] == 0) {
            fibNumbers[n] = getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
        }

        return fibNumbers[n];
    }
}
