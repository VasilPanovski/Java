import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr12_LittleJohn {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int smallCount = 0;
        int mediumCount = 0;
        int largeCount = 0;

        String inputLine = null;
        for (int i = 0; i < 4; i++) {
            inputLine = scn.nextLine();

            Pattern pattern = Pattern.compile("(>{3}-{5}>>)|(>>-{5}>)|(>-{5}>)");
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    largeCount++;
                } else if (matcher.group(2) != null) {
                    mediumCount++;
                } else {
                    smallCount++;
                }

            }
        }
        int number = Integer.valueOf(smallCount + "" + mediumCount + "" + largeCount);

        String numberToBin = Integer.toBinaryString(number);
        String reversedBinNumber = new StringBuilder(numberToBin).reverse().toString();
        String resultBinNumber = numberToBin + reversedBinNumber;

        number = Integer.parseInt(resultBinNumber, 2);
        System.out.println(number);
    }
}
