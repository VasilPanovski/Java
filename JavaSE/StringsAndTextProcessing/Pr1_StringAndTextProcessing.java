import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nobody on 31.5.2016 г..
 */
public class Pr1_StringAndTextProcessing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String reversedText = new StringBuilder(reader.readLine()).reverse().toString();
        System.out.println(reversedText);
    }
}
