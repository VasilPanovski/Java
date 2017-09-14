import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr3_StudentsByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .map(element -> element.split(" "))
                .filter(tokens -> Integer.parseInt(tokens[2]) >= 18 && Integer.parseInt(tokens[2]) <= 24)
                .forEach(tokens -> System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2]));

    }
}
