import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mm on 1.6.2016 г..
 */
public class Pr10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        Stack<String> undoesArguments = new Stack<>();
        int inputCommands = scn.nextInt();
        scn.nextLine();

        for (int i = 0; i < inputCommands; i++) {
            String[] tokens = scn.nextLine().trim().split(" ");
            String command = tokens[0];
            String argument = "";

            if (tokens.length > 1) {
                argument = tokens[1];
            } else if (tokens.length == 1 && !tokens[0].equals("4")) {
                continue;
            }

            switch (command) {
                case "1":
                    text.append(argument);
                    if (text.length() > 1_000_000) {
                        text.substring(0, 1_000_000);
                    }
                    undoesArguments.push(text.toString());
                    break;
                case "2":
                    text = new StringBuilder(text.toString().substring(0, text.length() - Integer.valueOf(argument)));
                    undoesArguments.push(text.toString());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.valueOf(argument) - 1));
                    break;
                case "4":
                    undoesArguments.pop();
                    text = new StringBuilder(undoesArguments.peek());
                    break;
            }
        }
    }
}
