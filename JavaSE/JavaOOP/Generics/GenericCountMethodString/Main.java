package pr5_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 16.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputLines = Integer.valueOf(reader.readLine());

        List<Box<Double>> elements = new ArrayList<>();
        Box<Double> box = null;
        for (int i = 0; i < inputLines; i++) {
            box = new Box<>(Double.valueOf(reader.readLine()));
            elements.add(box);
        }

        Box<Double> givenElement = new Box<>(Double.valueOf(reader.readLine()));
        int size = box.getComparedElementsSize(elements, givenElement);
        System.out.println(size);
    }
}
