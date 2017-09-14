import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Task10_CardFrequencies {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        String[] cards = input.nextLine().split("[ ♠♥♦♣]+");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < cards.length; i++) {
            String currentCard = cards[i];
            if (map.containsKey(currentCard)){
                map.put(currentCard, map.get(currentCard) + 1);
            } else {
                map.put(currentCard, 1);
            }
        }

        int cardCount = cards.length;
        for (String card : map.keySet()) {
            double percentage = map.get(card) * 100.0 / cardCount;
            System.out.printf("%s -> %.2f", card, percentage);
            System.out.println("%");

        }
    }
}
