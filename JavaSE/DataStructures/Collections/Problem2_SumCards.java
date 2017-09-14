import java.util.Arrays;
import java.util.Scanner;

public class Problem2_SumCards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] inputLine = input.nextLine().split("[ SHDC]+");
        int[] cardFaces = new int[inputLine.length];

        for (int i = 0; i < cardFaces.length; i++) {
            switch (inputLine[i]) {
                case "J": cardFaces[i] = 12; break;
                case "Q": cardFaces[i] = 13; break;
                case "K": cardFaces[i] = 14; break;
                case "A": cardFaces[i] = 15; break;
                default:
                    cardFaces[i] = Integer.parseInt(inputLine[i]);
                    break;
            }
        }

        int sum = 0;
        int counter = 1;
        for (int i = 0; i < cardFaces.length - 1; i++) {
            int currentNum = cardFaces[i];
            int nextNum = cardFaces[i + 1];

            if (currentNum == nextNum) {
                counter++;
            } else {
                if (counter > 1) {
                    sum += counter * currentNum * 2;
                } else {
                    sum += currentNum;
                }
                counter = 1;
            }
        }

        if (counter > 1) {
            sum += 2 * cardFaces[cardFaces.length - counter] * counter;
        } else {
            sum += cardFaces[cardFaces.length - 1];
        }
        System.out.println(sum);
    }
}
