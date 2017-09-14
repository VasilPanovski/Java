package comparators;

import java.util.TreeSet;

/**
 * Created by mm on 27.8.2016 г..
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    TreeSet<Person> persons;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.persons = new TreeSet<>();
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person givenPerson) {
        if (Integer.compare(this.getName().length(), givenPerson.getName().length()) < 0) {
            return -1;
        } else if (Integer.compare(this.getName().length(), givenPerson.getName().length()) > 0) {
            return 1;
        } else {
            if (Character.compare(this.getName().toLowerCase().charAt(0), givenPerson.getName().toLowerCase().charAt(0)) < 0) {
                return -1;
            } else if (Character.compare(this.getName().charAt(0), givenPerson.getName().charAt(0)) > 0) {
                return 1;
            }
        }

        return 0;
    }
}
