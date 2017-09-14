import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr2_StudentsByFirsAndLastName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .map(element -> element.split(" "))
                .filter(el -> el[0].compareTo(el[1]) < 0)
                .forEach(el -> System.out.printf("%s %s\n", el[0], el[1]));
    }
}
