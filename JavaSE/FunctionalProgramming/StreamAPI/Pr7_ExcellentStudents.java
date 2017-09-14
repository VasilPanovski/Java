import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr7_ExcellentStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .filter(str -> str.contains("6"))
                .map(el -> el.split(" "))
                .forEach(str -> System.out.println(str[0] + " " + str[1]));
    }
}
