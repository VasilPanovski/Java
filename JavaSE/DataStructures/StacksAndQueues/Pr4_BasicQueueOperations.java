import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mm on 26.5.2016 г..
 */
public class Pr4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int elementsToEnqueue = sc.nextInt();
        int elementsToDequeue = sc.nextInt();
        int elementToCheck = sc.nextInt();
        sc.nextLine();

        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < elementsToEnqueue; i++) {
            numbers.offer(sc.nextInt());
        }

        for (int i = 0; i < elementsToDequeue; i++) {
            numbers.poll();
        }

        if (numbers.isEmpty()) {
            System.out.println("0");
        } else if (numbers.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            int minNumber = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number < minNumber) {
                    minNumber = number;
                }
            }
            System.out.println(minNumber);
        }
    }
}
