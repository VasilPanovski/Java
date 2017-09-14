package pr5_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 21.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        String inputLine = null;
        while (!"END".equals(inputLine = reader.readLine())) {
            String[] params = inputLine.trim().split("\\s+");
            String name = params[0];
            int age = Integer.valueOf(params[1]);
            String town = params[1];
            persons.add(new Person(name, age, town));
        }

        int index = Integer.valueOf(reader.readLine());
        Person person = persons.remove(index - 1);

        int equalsPersonsCount = 0;
        for (Person per : persons) {
            if (per.compareTo(person) == 0) {
                equalsPersonsCount++;
            }
        }
        int differentPersonsCount = persons.size() - equalsPersonsCount + 1;
        int totalPersons = persons.size() + 1;

        if (equalsPersonsCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.print(equalsPersonsCount + " " + differentPersonsCount + " " + totalPersons);
        }
    }
}
