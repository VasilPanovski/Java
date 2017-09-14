package pr8_CardGame.models;

import pr8_CardGame.enums.CardRank;
import pr8_CardGame.enums.CardSuit;

/**
 * Created by mm on 21.7.2016 г..
 */
public class Card {
    private static final int RANK_VALUE = 2;
    private static final int SUIT_VALUE = 13;

    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.setCardRank(cardRank);
        this.setCardSuit(cardSuit);
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getCardPower() {
        int rankPower = this.getCardRank().ordinal() + RANK_VALUE;
        int suitPower = this.getCardSuit().ordinal() * SUIT_VALUE;
        int cardPower = rankPower + suitPower;

        return cardPower;
    }

    @Override
    public String toString() {
        return String.format("%s of %s.", this.getCardRank(), this.getCardSuit());
    }
}
