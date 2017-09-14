package pr7_DeckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 20.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        CardSuit[] cardSuits = CardSuit.values();
        CardRank[] cardRanks = CardRank.values();

        for (int i = 0; i < cardSuits.length; i++) {
            for (int j = 0; j < cardRanks.length; j++) {
                System.out.printf("%s of %s%n", cardRanks[j].name(), cardSuits[i].name());
            }
        }
    }
}
