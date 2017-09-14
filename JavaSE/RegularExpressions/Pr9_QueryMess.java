import java.util.*;

/**
 * Created by mm on 3.6.2016 г..
 */
public class Pr9_QueryMess {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> fieldPair = new LinkedHashMap<>();
        
        String inputLine;
        while (!"END".equals(inputLine = scn.nextLine())) {
            inputLine = inputLine.replaceAll("[+]+|%20", " ");
            inputLine = inputLine.replaceAll("\\s+", " ");
            String[] series = inputLine.trim().split("[&?]+");

            for (String sery : series) {
                if (sery.contains("=")) {
                    String[] pair = sery.trim().split("=");
                    String currentKey = pair[0].trim();
                    String currentValue = pair[1].trim();
                    if (!fieldPair.containsKey(currentKey)) {
                        fieldPair.put(currentKey, new ArrayList());
                    }
                    fieldPair.get(currentKey).add(currentValue);
                }
            }
            for (Map.Entry<String, ArrayList<String>> pair : fieldPair.entrySet()) {
                System.out.print(pair.getKey() + "=" + pair.getValue());
            }
            System.out.println();
            fieldPair = new LinkedHashMap<>();
        }
    }
}
