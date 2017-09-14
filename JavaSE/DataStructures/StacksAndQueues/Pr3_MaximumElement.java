import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by mm on 26.5.2016 г..
 */
public class Pr3_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int queriesCount = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        Stack<Integer> numbers = new Stack<>();
        String currentLine;
        for (int i = 0; i < queriesCount; i++) {
             currentLine = reader.readLine().trim();
            if (currentLine.length() > 1) {
                numbers.push(Integer.parseInt(currentLine.substring(2)));
            } else if (currentLine.equals("2")) {
                numbers.pop();
            } else {
                int maxNumber = Integer.MIN_VALUE;
                for (Integer number : numbers) {
                    if (number > maxNumber) {
                        maxNumber = number;
                    }
                }
                result.append(maxNumber).append("\n");
            }
        }
        reader.close();
        System.out.println(result);
    }
}
