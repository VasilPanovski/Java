package pr6_StrategyPattern;

import java.util.TreeSet;

public class AgeComparator extends Person implements Comparable<Person> {
    TreeSet<Person> persons;

    public AgeComparator(String name, int age) {
        super(name, age);
        this.persons = new TreeSet<>();
    }

    @Override
    public int compareTo(Person givenPerson) {
        if (Integer.compare(this.getAge(), givenPerson.getAge()) < 0) {
            return -1;
        } else if (Integer.compare(this.getAge(), givenPerson.getAge()) > 0) {
            return 1;
        }
        return 0;
    }
}
