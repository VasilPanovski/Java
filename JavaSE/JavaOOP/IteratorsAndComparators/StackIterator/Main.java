package pr3_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 19.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> elements = new ArrayList<>();
        Stack stack = new CustomStack();

        String inputLine = null;
        while (!"END".equals(inputLine = reader.readLine())) {
            String[] tokens = inputLine.split("[, ]+");

            String command = tokens[0];
            switch (command) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        elements.add(Integer.valueOf(tokens[i]));
                    }
                    stack.push(elements);
                    break;

                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;

                default:
                    break;
            }
            elements = new ArrayList<>();
        }

        System.out.print(stack.toString());
    }
}
