import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr9_StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .filter(str -> {
                    int year = Integer.parseInt((str.charAt(4) + "" + str.charAt(5)));
                    if (year == 14 || year == 15) {
                        return true;
                    }
                    return false;
                })
                .forEach(str -> System.out.println(str.substring(str.indexOf(" ") + 1)));
    }
}
