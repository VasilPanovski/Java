package pr6_StrategyPattern;

import java.util.TreeSet;

/**
 * Created by mm on 22.7.2016 г..
 */
public class NameComparator extends Person implements Comparable<Person> {
    TreeSet<Person> persons;

    public NameComparator(String name, int age) {
        super(name, age);
        this.persons = new TreeSet<>();
    }

    @Override
    public int compareTo(Person givenPrson) {
        if (Integer.compare(this.getName().length(), givenPrson.getName().length()) < 0) {
            return -1;
        } else if (Integer.compare(this.getName().length(), givenPrson.getName().length()) > 0) {
            return 1;
        } else {
            if (Character.compare(this.getName().toLowerCase().charAt(0), givenPrson.getName().toLowerCase().charAt(0)) < 0) {
                return -1;
            } else if (Character.compare(this.getName().charAt(0), givenPrson.getName().charAt(0)) > 0) {
                return 1;
            }
        }

        return 0;
    }
}
