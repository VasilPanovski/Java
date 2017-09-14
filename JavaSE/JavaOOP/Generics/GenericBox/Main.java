package pr1_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 15.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int linesCount = Integer.valueOf(reader.readLine());

        for (int i = 0; i < linesCount; i++) {
            Box<Integer> box = new Box(Integer.valueOf(reader.readLine()));
            System.out.println(box.toString());
        }
    }
}
