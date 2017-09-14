package pr3_CardsWithPower.models;

import pr3_CardsWithPower.enums.CardRank;
import pr3_CardsWithPower.enums.CardSuit;

/**
 * Created by mm on 20.7.2016 г..
 */
public class CardPower implements Comparable<CardPower> {

    private static final int RANK_VALUE = 2;
    private static final int SUIT_VALUE = 13;

    private CardRank cardRank;
    private CardSuit cardSuit;

    public CardPower(CardRank cardRank, CardSuit cardSuit) {
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

    private int calculateCardPower() {
        int rankPower = cardRank.ordinal() + RANK_VALUE;
        int suitPower = cardSuit.ordinal() * SUIT_VALUE;
        int cardPower = rankPower + suitPower;

        return cardPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.getCardRank(),
                this.getCardSuit(),
                calculateCardPower());
    }

    @Override
    public int compareTo(CardPower o) {
        return Integer.compare(this.calculateCardPower(), o.calculateCardPower());
    }
}
