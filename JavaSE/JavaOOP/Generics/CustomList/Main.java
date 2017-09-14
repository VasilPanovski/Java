package pr7_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 16.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomListImpl<String> customList = new CustomListImpl<>();

        String element = null;
        String inputLine = null;
        while (!"END".equals(inputLine = reader.readLine())) {
            String[] tokens = inputLine.trim().split("\\s+");

            String command = tokens[0];
            switch (command) {
                case "Add":
                    element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.valueOf(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.valueOf(tokens[1]);
                    int secondIndex = Integer.valueOf(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(customList.countGreaterThat(element));
                    break;
                case "Print":
                    for (String el : customList) {
                        System.out.println(el);
                    }
                    break;
                case "Sort":
                    Sortable<String> sorter = new Sort<>();
                    sorter.sort(customList);
                    break;

                default:
                    break;
            }
        }
    }
}
