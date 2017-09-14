package pr2_CardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 20.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputTokens = reader.readLine().split("\\s+");

        String rankCommand = inputTokens[1];

        if (rankCommand.equals("Ranks")) {
            CardRank[] ranks = CardRank.values();

            System.out.println("Card Ranks:");
            for (CardRank rank : ranks) {
                System.out.println(String.format("Ordinal value: %d; Name value: %s", rank.ordinal(), rank.name()));
            }
        }
    }
}
