import java.util.*;

public class Task4_LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] inputLine = input.nextLine().split(" ");
        int[] numbers = new int[inputLine.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println("Result:");
        int length = 1;
        int maxLength = 1;
        int startIndex = 0;
        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] > numbers[index - 1]) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = index - length;
                }
                printSequence(index - length, length, numbers);
                length = 1;
            }
            if (index == numbers.length - 1 && length <= maxLength) {
                printSequence(numbers.length - length, length, numbers);
            }
        }


        if (length > maxLength) {
            maxLength = length;
            startIndex = numbers.length - length;
            int counter = length;
            for (int i = 0; i < length; i++) {
                System.out.print(numbers[numbers.length - counter] + " ");
                counter--;
            }
        }
        System.out.println();
        System.out.print("Longest: ");
        printSequence(startIndex, maxLength, numbers);

        System.out.println();

        // WITH QUEUE
        System.out.println("Result with QUEUE:");

        Queue<Integer> sequence = new LinkedList<>();
        Queue<Integer> longestSequence = new LinkedList<>();

        for (int index = 0; index < numbers.length - 1; index++) {
            int currentNumber = numbers[index];
            int nextNumber = numbers[index + 1];

            if (currentNumber < nextNumber) {
                sequence.add(currentNumber);
            } else {
                sequence.add(currentNumber);
                if (sequence.size() > longestSequence.size()) {
                    longestSequence.clear();
                    longestSequence.addAll(sequence);
                }
                printQueue(sequence);
            }
        }

        if (sequence.size() == numbers.length - 1) {
            sequence.add(numbers[numbers.length - 1]);
            longestSequence.addAll(sequence);
        } else {
            sequence.add(numbers[numbers.length - 1]);
        }

        if (longestSequence.size() < sequence.size()) {
            longestSequence.add(numbers[numbers.length - 1]);
        }

        printQueue(sequence);
        System.out.print("Longest: ");
        printQueue(longestSequence);
    }


    public static void printSequence(int startIndex, int length, int[] array) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[startIndex] + " ");
            startIndex++;
        }
        System.out.println();
    }

    public static void printQueue(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.printf("%d ", queue.poll());
        }
        System.out.println();
    }
}

