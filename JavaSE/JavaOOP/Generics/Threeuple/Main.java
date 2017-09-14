package pr11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 17.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineTokens = reader.readLine().trim().split("\\s+");
        String firstName = firstLineTokens[0] + " " + firstLineTokens[1];
        String address = firstLineTokens[2];
        String town = firstLineTokens[3];
        Threeuple<String, String, String> firstThreeuple = new ThreeupleImpl<>(firstName, address, town);
        System.out.println(firstThreeuple.toString());

        String[] secondLineTokens = reader.readLine().trim().split("\\s+");
        String secondName = secondLineTokens[0];
        int litersOfBeer = Integer.valueOf(secondLineTokens[1]);
        boolean isDrunk = secondLineTokens[2].equals("drunk") ? true : false;
        Threeuple<String, Integer, Boolean> secondThreeuple = new ThreeupleImpl<>(secondName, litersOfBeer, isDrunk);
        System.out.println(secondThreeuple.toString());

        String[] thirdLineTokens = reader.readLine().trim().split("\\s+");
        String thirdName = thirdLineTokens[0];
        double accountBalance = Double.valueOf(thirdLineTokens[1]);
        String bankName = thirdLineTokens[2];
        Threeuple<String, Double, String> thirdThreeuple = new ThreeupleImpl<>(thirdName, accountBalance, bankName);
        System.out.println(thirdThreeuple.toString());
    }
}
