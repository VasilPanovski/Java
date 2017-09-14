import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr8_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String firstNum = scn.nextLine();
        int secondNum = Integer.parseInt(scn.nextLine());

        if (secondNum == 0 || firstNum.equals("0")) {
            System.out.println("0");
            return;
        }
        StringBuilder result = new StringBuilder();
        int currentResult,
                currentDigit;
        int temp = 0;

        for (int index = firstNum.length() - 1; index >= 0; index--) {
            currentDigit = Integer.parseInt(firstNum.charAt(index)+"");
            currentResult = currentDigit*secondNum + temp;

            temp = currentResult / 10;
            result.append(currentResult % 10);
        }
        if (temp > 0) {
            result.append(temp);
        }

        int i = result.length() - 1;
        while (result.charAt(i) == '0') {
            result.deleteCharAt(i);
            i--;
        }
        System.out.println(result.reverse().toString());
    }
}
