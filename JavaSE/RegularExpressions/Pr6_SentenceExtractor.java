import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mm on 2.6.2016 г..
 */
public class Pr6_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String kyeword = reader.readLine();
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("[^!?.]+[?!.]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String sentence = matcher.group();
            String[] tokens = sentence.split(String.format(" %s ", kyeword));
            if (tokens.length > 1) {
                System.out.println(sentence);
            }
        }
    }
}
