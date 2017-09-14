package pr5_BorderControl;

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

        List<Detainable> persons = new ArrayList<>();

        String input = null;
        while (!"End".equals(input = reader.readLine())) {
            String[] params = input.trim().split("\\s+");

            String name = params[0];
            String id = params[params.length - 1];
            if (params.length == 3) {
                int age = Integer.valueOf(params[1]);
                Detainable citizen = new Citizen(name, age, id);
                persons.add(citizen);
            } else {
                Detainable robot = new Robot(name, id);
                persons.add(robot);
            }
        }

        String specifiedDigits = reader.readLine();

        for (Detainable person : persons) {
            if (person instanceof Citizen && ((Citizen) person).getId().endsWith(specifiedDigits)) {
                person.detain();
            }

            if (person instanceof Robot && ((Robot) person).getId().endsWith(specifiedDigits)) {
                person.detain();
            }
        }
    }
}
