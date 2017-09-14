package pr7_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by mm on 23.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> treeSetPersons = new TreeSet<>();
        HashSet<Person> hashSetPersons = new HashSet<>();

        int inputLines = Integer.valueOf(reader.readLine());

        for (int i = 0; i < inputLines; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.valueOf(params[1]);

            treeSetPersons.add(new Person(name, age));
            hashSetPersons.add(new Person(name, age));
        }

        System.out.println(treeSetPersons.size());
        System.out.println(hashSetPersons.size());
    }
}
