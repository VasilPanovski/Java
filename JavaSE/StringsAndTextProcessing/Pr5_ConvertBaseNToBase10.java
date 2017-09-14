import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr5_ConvertBaseNToBase10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int base = scn.nextInt();
        int power = 0;
        String inputNum = scn.next();
        int maxPower = inputNum.length() ;
        BigInteger number = new BigInteger(inputNum);

        BigInteger sum = BigInteger.ZERO;
        BigInteger currentDigit = BigInteger.ZERO;
        while (power <= maxPower ) {
            currentDigit = number.remainder(new BigInteger(String.valueOf(10)));
            sum = sum
                .add(new BigInteger(String.valueOf(currentDigit))
                .multiply(new BigInteger(String.valueOf(base))
                .pow(power++)));

            number = number.divide(new BigInteger(String.valueOf(10)));
        }
        System.out.println(sum);
    }
}
