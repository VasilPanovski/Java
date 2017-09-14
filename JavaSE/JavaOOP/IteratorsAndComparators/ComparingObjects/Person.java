package pr5_ComparingObjects;

/**
 * Created by mm on 21.7.2016 г..
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid person name!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid person age!");
        }
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town == null || town.isEmpty()) {
            throw new IllegalArgumentException("Invalid person town!");
        }
        this.town = town;
    }

    @Override
    public int compareTo(Person givenPerson) {
        if (this.getName().compareTo(givenPerson.getName()) == 0) {
            return 0;
        } else if (Integer.compare(this.getAge(), givenPerson.getAge()) == 0) {
            return 0;
        } else  if (this.getTown().compareTo(givenPerson.getTown()) == 0) {
            return 0;
        }
        return -1;
    }
}
