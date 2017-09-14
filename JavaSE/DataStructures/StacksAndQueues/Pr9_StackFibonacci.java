import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mm on 1.6.2016 г..
 */
public class Pr9_StackFibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Stack<BigInteger> fibNumbers = new Stack<>();

        long n = scn.nextLong();
        fibNumbers.push(new BigInteger("1"));
        fibNumbers.push(new BigInteger("1"));

        BigInteger currentFibNum = BigInteger.ZERO;
        BigInteger firstFibNum = BigInteger.ZERO;
        BigInteger secondFubNum = BigInteger.ZERO;
        BigInteger tempNum = BigInteger.ZERO;

        int counter = 1;
        while (counter != n) {
            secondFubNum = fibNumbers.pop();
            firstFibNum = fibNumbers.pop();
            tempNum = secondFubNum;
            currentFibNum = firstFibNum.add(secondFubNum);
            //System.out.print(currentFibNum + " ");
            counter++;

            fibNumbers.push(tempNum);
            fibNumbers.push(currentFibNum);
        }
        System.out.println(fibNumbers.peek());
    }
}
