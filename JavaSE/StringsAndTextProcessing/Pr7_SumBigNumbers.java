import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr7_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String firstNum = scn.nextLine().trim();
        String secondNum = scn.nextLine().trim();

        if (firstNum.length() != secondNum.length()) {
            int subjoinLength = Math.abs(firstNum.length() - secondNum.length());

            if (firstNum.length() < secondNum.length()) {
                firstNum = new String(new char[subjoinLength]).replace("\0", "0") + firstNum;
            } else {
                secondNum = new String(new char[subjoinLength]).replace("\0", "0") + secondNum;
            }
        }

        StringBuilder sum = new StringBuilder();
        int firstCurrentDigit,
                secondCurrentDigit,
                currentSum;
        int temp = 0;
        for (int index = firstNum.length() - 1; index >= 0; index--) {
            firstCurrentDigit = Integer.parseInt(String.valueOf(firstNum.charAt(index)));
            secondCurrentDigit = Integer.parseInt(String.valueOf(secondNum.charAt(index)));
            currentSum = firstCurrentDigit + secondCurrentDigit + temp;

            temp = currentSum / 10;
            sum.append(currentSum % 10);
        }
        if (temp > 0) {
            sum.append(temp);
        }

        int i = sum.length() - 1;
        while (sum.charAt(i) == '0') {
            sum.deleteCharAt(i);
            i--;
        }
        String result = sum.reverse().toString();
        System.out.println(result);
    }
}
