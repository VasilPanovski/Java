package pr6_BirthdayCelebrations;

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

        List<BirthdayCelebratable> persons = new ArrayList<>();

        String input = null;
        while (!"End".equals(input = reader.readLine())) {
            String[] params = input.trim().split("\\s+");

            String name = params[1];
            String birthdate = params[params.length - 1];

            try {
                if (!params[0].toLowerCase().equals("robot")) {
                    if (params.length == 5) {
                        int age = Integer.valueOf(params[2]);
                        String id = params[3];

                        BirthdayCelebratable citizen = new Citizen(name, age, id, birthdate);
                        persons.add(citizen);
                    } else {
                        BirthdayCelebratable pet = new Pet(name, birthdate);
                        persons.add(pet);
                    }
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        String givenYear = reader.readLine();

        for (BirthdayCelebratable person : persons) {
            if (person instanceof Citizen && ((Citizen) person).getBirthdate().endsWith(givenYear)) {
                person.printBirthdate();
            }

            if (person instanceof Pet && ((Pet) person).getBirthdate().endsWith(givenYear)) {
                person.printBirthdate();
            }
        }
    }
}
