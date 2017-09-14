import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr5_FilterStudentsByEmailDomain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream().map(el -> el.split("\\s+"))
                .filter(str -> str[2].contains("@gmail.com"))
                .forEach(str -> System.out.println(str[0] + " " + str[1]));
    }
}
