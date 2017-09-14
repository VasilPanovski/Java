import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mm on 26.5.2016 г..
 */
public class Pr5_CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<BigInteger> sequence = new ArrayDeque<>();
        ArrayList<BigInteger> seqNumbers = new ArrayList<>();

        BigInteger number = new BigInteger(sc.nextLine());
        seqNumbers.add(number);
        sequence.push(number);

        BigInteger s1 = BigInteger.ZERO;
        BigInteger s2 = BigInteger.ZERO;
        BigInteger s3 = BigInteger.ZERO;

        while (seqNumbers.size() < 50) {
            s1 = sequence.peek().add(new BigInteger("1"));
            sequence.offer(s1);
            s2 = sequence.peek().multiply(new BigInteger("2")).add(new BigInteger("1"));
            sequence.offer(s2);
            s3 = s1.add(new BigInteger("1"));
            sequence.offer(s3);

            seqNumbers.add(s1);
            seqNumbers.add(s2);
            seqNumbers.add(s3);

            sequence.removeFirst();

        }

        for (int i = 0; i < 50; i++) {
            System.out.print(seqNumbers.get(i) + " ");
        }
    }
}
