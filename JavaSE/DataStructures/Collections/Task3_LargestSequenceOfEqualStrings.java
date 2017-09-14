import java.util.*;

public class Task3_LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //WITH STRING
        String[] array = input.nextLine().split(" ");
        System.out.println("Result using String:");
        int length = 1;
        int maxLength = 1;
        String bestString = array[0];

        for (int index = 0; index < array.length - 1; index++) {
            if (array[index].equals(array[index + 1])) {
                length++;
            } else {
                if (length > maxLength){
                    maxLength = length;
                    bestString = array[index];
                }
                length = 1;
            }
        }

        if (length > maxLength){
            maxLength = length;
            bestString = array[array.length - 1];
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print(bestString + " ");
        }

        System.out.println();


         //WITH MAP:
        System.out.println("Result using HashMap:");
        Map<String, Integer> map = new HashMap<>();
        String element;
        int length1 = 1;
        for (int i = 0; i < array.length; i++) {
            element = array[i];
            if (map.containsKey(element)) {
                length1++;
                map.put(element, length1);
            } else {
                length1 = 1;
                map.put(element, length1);
            }

        }
        int maxLength1 = Collections.max(map.values());
        for (String kye : map.keySet()) {
            if (map.get(kye) == maxLength1) {
                for (int i = 0; i < maxLength1; i++) {
                    System.out.print(kye + " ");
                }
                break;
            }
        }
    }
}
