package pr9_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 25.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomLinkedListImpl<Integer> numbers = new CustomLinkedListImpl<>();

        int inputLines = Integer.valueOf(reader.readLine());
        for (int i = 0; i < inputLines; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];
            int number = Integer.valueOf(tokens[1]);

            switch (command.toLowerCase()) {
                case "add":
                    numbers.add(number);
                    break;
                case "remove":
                    numbers.remove(number);
                    break;
            }
        }

        System.out.println(numbers.getSize());
        numbers.forEach(n -> System.out.print(n + " "));
    }
}
