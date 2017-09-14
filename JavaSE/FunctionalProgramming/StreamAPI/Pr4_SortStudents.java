import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr4_SortStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            inputData.add(currentLine);
        }

        inputData.stream()
                .map(el -> el.split("\\s+"))
                .sorted((fn1, fn2) -> fn2[0].compareTo(fn1[0]))
                .sorted((ln1, ln2) -> ln1[1].compareTo(ln2[1]))
                .forEach(name -> System.out.println(name[0] + " " + name[1]));
    }
}
