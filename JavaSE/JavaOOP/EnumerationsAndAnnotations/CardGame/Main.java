package pr8_CardGame;

import pr8_CardGame.enums.CardRank;
import pr8_CardGame.enums.CardSuit;
import pr8_CardGame.models.Card;
import pr8_CardGame.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 21.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        while (firstPlayer.getHand().size() < 5 || secondPlayer.getHand().size() < 5) {
            String[] cardTokens = reader.readLine().split("\\s+of\\s+");

            String cardRank = cardTokens[0];
            String cardSuit = cardTokens[1];
            if (firstPlayer.getHand().size() < 5) {
                getCards(firstPlayer, cardRank, cardSuit);
            } else {
                getCards(secondPlayer, cardRank, cardSuit);
            }
        }

        Card bestCard = null;
        String winner = null;
        if (firstPlayer.getBestCard().getCardPower() > secondPlayer.getBestCard().getCardPower()) {
            bestCard = firstPlayer.getBestCard();
            winner = firstPlayerName;
        } else {
            bestCard = secondPlayer.getBestCard();
            winner = secondPlayerName;
        }

        System.out.println(String.format("%s wins with %s", winner, bestCard.toString()));
    }


    private static void getCards(Player player, String cardRank, String cardSuit) {

        if (!isValidRank(cardRank) || !isValidSuit(cardSuit)) {
            System.out.println("No such card exists.");
            return;
        }

        CardRank rank = CardRank.valueOf(cardRank);
        CardSuit suit = CardSuit.valueOf(cardSuit);

        try {
            Card currentCard = new Card(rank, suit);
            player.addCard(currentCard);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }


    private static boolean isValidSuit(String cardSuit) {
        CardSuit[] suits = CardSuit.values();
        for (CardSuit suit : suits) {
            if (suit.name().equals(cardSuit)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidRank(String cardRank) {
        CardRank[] cardRanks = CardRank.values();
        for (CardRank rank : cardRanks) {
            if (rank.name().equals(cardRank)) {
                return true;
            }
        }
        return false;
    }
}
