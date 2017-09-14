import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 2.6.2016 г..
 */
public class Pr4_ReplaceATag {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String currentLine;
        while (!"end".equals(currentLine = reader.readLine())) {
            sb.append(currentLine);
        }
        reader.close();
        String result = sb.toString().replaceAll("<a", "[URL");
        result = result.replace("</a>", "[/URL]");

        System.out.println(result);
    }
}
