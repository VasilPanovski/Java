package pr3_GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 15.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputLines = Integer.valueOf(reader.readLine());
        List<Integer> elements = new ArrayList<>();

        BoxImpl<Integer> box = new BoxImpl<>();
        for (int i = 0; i < inputLines; i++) {
            int currentElement = Integer.valueOf(reader.readLine());
            elements.add(currentElement);
        }

        String[] indexes = reader.readLine().split("\\s+");
        int firstIndex = Integer.valueOf(indexes[0]);
        int secondIndex = Integer.valueOf(indexes[1]);

        box.swapElements(elements, firstIndex, secondIndex);

        System.out.println(box.toString(elements));
    }
}
