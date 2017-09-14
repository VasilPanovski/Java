package pr7_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 12.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Buyer> buyers = new ArrayList<>();

        int buyersCount = Integer.valueOf(reader.readLine());

        for (int i = 0; i < buyersCount; i++) {
            String[] params = reader.readLine().trim().split("\\s+");

            String name = params[0];
            int age = Integer.valueOf(params[1]);
            try {
                if (params.length == 3) {
                    String group = params[2];

                    Buyer rebel = new Rebel(name, age, group);
                    buyers.add(rebel);
                } else {
                    String id = params[2];
                    String birtdate = params[3];

                    Buyer citizen = new Citizen(name, age, id, birtdate);
                    buyers.add(citizen);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        int totalFoodBought = 0;
        String inputName = null;
        while (!"End".equals(inputName = reader.readLine())) {
            for (Buyer buyer : buyers) {
                if (buyer instanceof Citizen && ((Citizen) buyer).getName().equals(inputName)) {
                    buyer.buyFood();
                    totalFoodBought += buyer.getFood();
                }

                if (buyer instanceof Rebel && ((Rebel) buyer).getName().equals(inputName)) {
                    buyer.buyFood();
                    totalFoodBought += buyer.getFood();
                }
            }
        }

        System.out.println(totalFoodBought);
    }
}
