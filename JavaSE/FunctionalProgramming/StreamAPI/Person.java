import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by mm on 14.5.2016 г..
 */
public class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = sc.nextLine())) {
            String[] data = currentLine.trim().split("\\s+");
            String name = data[0] + " " + data[1];
            int group = Integer.parseInt(data[2]);

            persons.add(new Person(name, group));
        }

        Map<Integer, List<Person>> personsByGroup = persons
                .stream()
                .collect(Collectors.groupingBy(person -> person.group));

        personsByGroup.forEach((group, person) -> System.out.println(group + " - " +
                new StringBuilder(person.toString())
                        .deleteCharAt(0)
                        .deleteCharAt(person.toString().length() - 2)));
    }
}
