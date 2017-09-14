import java.util.Scanner;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr2_StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();
        if (inputText.length() <= 20) {
            System.out.println(inputText + new String(new char[20 - inputText.length()]).replace("\0", "*"));
        } else {
            System.out.println(inputText.substring(0, 20));
        }
    }
}
