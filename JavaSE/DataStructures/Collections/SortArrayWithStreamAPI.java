import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortArrayWithStreamAPI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputLine = input.nextLine().split(" ");
        String sortOrder = input.nextLine();
        List<Integer> numbers = new ArrayList<>(inputLine.length);
        for (int i = 0; i < inputLine.length; i++) {
            numbers.add(Integer.parseInt(inputLine[i]));
        }

        if (sortOrder.equals("Ascending")) {
            numbers.stream().sorted((i, k) -> i - k).collect(Collectors.toList()).forEach(i -> System.out.print(i + " "));
        } else {
            numbers.stream().sorted((i, k) -> k - i).collect(Collectors.toList()).forEach(i -> System.out.print(i + " "));
        }
    }
}
