import java.util.*;

public class Task9_MostFrequentWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = input.nextLine().toLowerCase().split("\\W+");
        Map<String, Integer> wordMap = new TreeMap<>();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (wordMap.containsKey(currentWord)) {
                wordMap.put(currentWord, wordMap.get(currentWord) + 1);
            } else {
                wordMap.put(currentWord, 1);
            }
        }
        int maxCount = Collections.max(wordMap.values());

        for (String s : wordMap.keySet()) {
            if (wordMap.get(s) == maxCount) {
                System.out.printf("%s -> %d times\n", s, wordMap.get(s));
            }
        }
    }
}
