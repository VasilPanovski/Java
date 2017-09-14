import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr6_FilterStudentsByPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .map(el -> el.split(" "))
                .filter(str -> str[2].startsWith("02") || str[2].startsWith("+3592"))
                .forEach(str -> System.out.println(str[0] + " " + str[1]));
    }
}
