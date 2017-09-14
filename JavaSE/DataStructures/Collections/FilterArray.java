import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] inputLine = input.nextLine().split(" ");
        List<String> words = new ArrayList<>();
        for (int i = 0; i < inputLine.length; i++) {
            words.add(inputLine[i]);
        }
        List<String> filteredWords = words.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
        System.out.println(filteredWords);
    }
}
