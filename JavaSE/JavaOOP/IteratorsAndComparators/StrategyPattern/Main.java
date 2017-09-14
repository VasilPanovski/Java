package pr6_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by mm on 22.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> nameComparePersons = new TreeSet<>();
        TreeSet<Person> ageComparePersons = new TreeSet<>();

        int inputLines = Integer.valueOf(reader.readLine());

        for (int i = 0; i < inputLines; i++) {
            String[] params = reader.readLine().trim().split("\\s+");
            String name = params[0];
            int age = Integer.valueOf(params[1]);

            Person personWithNameComparator = new NameComparator(name, age);
            nameComparePersons.add(personWithNameComparator);
            Person personWithAgeComparator = new AgeComparator(name, age);
            ageComparePersons.add(personWithAgeComparator);
        }

        nameComparePersons.stream().forEach(System.out::println);
        ageComparePersons.stream().forEach(System.out::println);
    }
}
