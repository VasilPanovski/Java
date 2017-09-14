import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr8_WeekStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .filter(str -> {
                    if (str.length() - str.replace("2", "").length() > 1) {
                        return true;
                    } else if (str.length() - str.replace("3", "").length() > 1) {
                        return true;
                    } else if (str.contains("2") && str.contains("3")) {
                        return true;
                    }
                    return false;
                })
                .map(str -> str.split(" "))
                .forEach(str -> System.out.println(str[0] + " " + str[1]));
    }
}
