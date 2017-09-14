package pr9_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mm on 21.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        ArrayList<String> lights = new ArrayList<>(Arrays.asList(tokens));
        int input = Integer.valueOf(reader.readLine());

        for (int i = 0; i < input; i++) {
            Light current = Light.valueOf(lights.remove(lights.size() - 1));
            lights.add(0, current.name());

            lights.stream().forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }
}
