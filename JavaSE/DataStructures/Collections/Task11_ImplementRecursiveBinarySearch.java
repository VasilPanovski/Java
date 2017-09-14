import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task11_ImplementRecursiveBinarySearch {
    public static int binarySearch(List<Integer> numbers, int startIndex, int lastIndex, int target) {
        int middleIndex = (startIndex + lastIndex) / 2;
        if (lastIndex < startIndex) {
            return -1;
        }

        if (target == numbers.get(middleIndex)){
            return middleIndex;
        }else if (target < numbers.get(middleIndex)) {
            return binarySearch(numbers, startIndex, middleIndex - 1, target);
        } else {
            return binarySearch(numbers, middleIndex + 1, lastIndex, target);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int target = Integer.parseInt(input.nextLine());
        String[] inputNumbers = input.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            int currentNum = Integer.parseInt(inputNumbers[i]);
            numbers.add(currentNum);
        }
        numbers.stream().sorted().collect(Collectors.toList());

        int result = binarySearch(numbers, 0, numbers.size() - 1, target);
        System.out.println(result);
    }
}
