import java.util.Arrays;
import java.util.Scanner;

public class Task1_SortArrayOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[] numbers = new int[n];
        String[] inputLine = input.nextLine().split(" ");

        for (int i = 0; i < inputLine.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }
        Arrays.sort(numbers);
        System.out.print(Arrays.toString(numbers));
    }
}
