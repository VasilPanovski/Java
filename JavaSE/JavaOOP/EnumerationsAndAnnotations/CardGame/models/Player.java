package pr8_CardGame.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private List<Card> hand;
    private Card bestCard;

    public Player(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        bestCard = null;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void addCard(Card givenCard) {
        for (Card card : this.hand) {
            if (card.getCardSuit().equals(givenCard.getCardSuit()) &&
                    card.getCardRank().equals(givenCard.getCardRank())) {
                throw new IllegalArgumentException("Card is not in the deck.");
            }
        }

        this.hand.add(givenCard);
    }

    public Card getBestCard() {
        List<Card> cards = this.hand.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getCardPower(), c1.getCardPower()))
                .collect(Collectors.toList());
        return cards.get(0);
    }
}
