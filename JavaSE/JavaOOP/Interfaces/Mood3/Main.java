package pr10_Mood3;

import pr10_Mood3.models.Archangel;
import pr10_Mood3.models.Demon;
import pr10_Mood3.models.GameObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 14.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputParams = reader.readLine().trim().split("\\s+\\|\\s+");
        String userName = inputParams[0];
        String characterType = inputParams[1];
        int level = Integer.valueOf(inputParams[3]);


        if (characterType.equals("Demon")) {
            double specialPoints = Double.valueOf(inputParams[2]);
            GameObject<Double> player = new Demon(userName, characterType, specialPoints);
            System.out.println(player.toString() + specialPoints * level);
        } else {
            int specialPoints = Integer.valueOf(inputParams[2]);
            GameObject<Integer> player = new Archangel(userName, characterType, specialPoints);
            System.out.println(player.toString() + specialPoints * level);
        }
    }
}
