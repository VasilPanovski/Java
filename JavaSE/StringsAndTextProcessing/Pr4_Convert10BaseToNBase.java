import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr4_Convert10BaseToNBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String base = scn.next();
        BigInteger number = scn.nextBigInteger();

        StringBuilder sb = new StringBuilder();
        while (!number.equals(BigInteger.ZERO)) {
            sb.append(number.remainder(new BigInteger(base)));
            number = number.divide(new BigInteger(String.valueOf(base)));
        }
        String result = sb.reverse().toString();
        System.out.println(result);
    }
}
