import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_SimpleExpression {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[\\s\\+\\-]*[\\d\\.]+");
        Matcher matcher = pattern.matcher(input.nextLine());

        BigDecimal sum = new BigDecimal(0.0);

        String number;
        while (matcher.find()) {
            String currentMatch = matcher.group();
            if (currentMatch.contains("+")) {
                number = currentMatch.replaceFirst("[\\s\\+]+", "").trim();
                sum = sum.add(new BigDecimal(number));
            } else if (currentMatch.contains("-")) {
                number = currentMatch.replaceFirst("[\\s\\-]+", "").trim();
                sum = sum.subtract(new BigDecimal(number));
            } else {
                number = currentMatch.replaceFirst("\\s+", "").trim();
                sum = sum.add(new BigDecimal(number));
            }
        }
        System.out.println(sum.setScale(7, BigDecimal.ROUND_DOWN));
    }
}
