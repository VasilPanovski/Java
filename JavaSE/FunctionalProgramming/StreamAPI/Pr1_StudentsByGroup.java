import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr1_StudentsByGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream().filter(s -> s.contains("2"))
                .sorted((name1, name2) -> name1.substring(0, name1.indexOf(" ")).compareTo(name2.substring(0, name2.indexOf(" "))))
                .forEach(s -> System.out.println(s.substring(0, s.indexOf('2'))));
    }
}
