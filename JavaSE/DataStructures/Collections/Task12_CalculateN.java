import java.util.Scanner;

public class Task12_CalculateN {
    public static long calculateFactorual(int n) {
        long result = 1;
        if (n < 1) {
            return 1;
        }
        result = calculateFactorual(n - 1) * n;
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        System.out.println(calculateFactorual(number));
    }
}
