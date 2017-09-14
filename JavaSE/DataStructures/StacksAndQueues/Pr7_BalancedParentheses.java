import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mm on 29.5.2016 г..
 */
public class Pr7_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine().trim();
        if (input.length() % 2 != 0 || input.trim().length() == 0) {
            System.out.println("NO");
            return;
        }

        Stack<Character> leftPart = new Stack<>();
        Stack<Character> rightPart = new Stack<>();
        int iterations = input.length() / 2;

        for (int i = 0; i < iterations; i++) {
            leftPart.push(input.charAt(i));
            rightPart.push(input.charAt(input.length() - 1 - i));
        }
        if (leftPart.size() != rightPart.size()) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < iterations; i++) {
            if ((leftPart.peek() == '(' && rightPart.peek() != ')') ||
                    (leftPart.peek() == '{' && rightPart.peek() != '}') ||
                    (leftPart.peek() == '[' && rightPart.peek() != ']')) {
                System.out.println("NO");
                return;
            }

            leftPart.pop();
            rightPart.pop();
        }

        if (leftPart.isEmpty() && rightPart.isEmpty()) {
            System.out.println("YES");
        }
    }
}
