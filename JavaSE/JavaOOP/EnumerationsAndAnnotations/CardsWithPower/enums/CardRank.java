package pr3_CardsWithPower.enums;

import pr3_CardsWithPower.anotations.CustomAnnotation;

@CustomAnnotation(category = "Rank", description = "Provides rank constants for a Card class.")
public enum CardRank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
}
