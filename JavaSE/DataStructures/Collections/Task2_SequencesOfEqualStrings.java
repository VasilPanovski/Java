import java.util.*;

public class Task2_SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] array = input.nextLine().split(" ");

        String previosElement;
        String result = array[0];
        for (int index = 1; index < array.length; index++) {
            previosElement = array[index-1];
            if (array[index].equals(previosElement)) {
                result += " " + array[index];
            } else {
                System.out.print(result + "\n");
                result = array[index];
            }
        }
        System.out.println(result);
    }
}
