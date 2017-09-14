package pr4_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by mm on 20.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] elements = Arrays.stream(reader.readLine().split("[, ]+")).mapToInt(Integer::valueOf).toArray();

        Lake lake = new Lake(elements);

        StringBuilder sb = new StringBuilder();
        for (Object o : lake) {
            sb.append(o).append(", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());

    }
}
