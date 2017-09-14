package pr10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 17.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineTokens = reader.readLine().trim().split("\\s+");

        String firstKey = firstLineTokens[0] + " " + firstLineTokens[1];
        String firstValue = firstLineTokens[2];
        Tuple<String, String> firstTuple = new TupleImpl<>(firstKey, firstValue);
        System.out.println(firstTuple.toString());

        String[] secondLineTokens = reader.readLine().trim().split("\\s+");
        String secondKey = secondLineTokens[0];
        int secondValue = Integer.valueOf(secondLineTokens[1]);
        Tuple<String, Integer> secondTuple = new TupleImpl<>(secondKey, secondValue);
        System.out.println(secondTuple.toString());

        String[] thirdLineTokens = reader.readLine().trim().split("\\s+");
        String thirdKey = thirdLineTokens[0];
        Double thirdValue = Double.valueOf(thirdLineTokens[1]);
        Tuple<String, Double> thirdTuple = new TupleImpl<>(thirdKey, thirdValue);
        System.out.println(thirdTuple.toString());
    }
}
