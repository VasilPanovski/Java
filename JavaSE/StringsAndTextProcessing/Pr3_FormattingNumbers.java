import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr3_FormattingNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        double b = scn.nextDouble();
        double c = scn.nextDouble();

        String aToHes = Integer.toHexString(a).toUpperCase();
        String aToBinary = Integer.toBinaryString(a);
        if (aToBinary.length() > 10) {
            aToBinary = aToBinary.substring(0, 10);
        } else {
            aToBinary = String.format("%010d", Integer.valueOf(aToBinary));
        }
        System.out.println(String.format("|%-10s|%s|%10.2f|%-10.3f|",
                                                  aToHes.toUpperCase(),
                                                  aToBinary, b, c));
    }
}
