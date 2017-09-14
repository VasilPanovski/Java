package pr6_BirthdayCelebrations;

import pr5_BorderControl.Detainable;

/**
 * Created by mm on 12.7.2016 г..
 */
public class Citizen implements Detainable, BirthdayCelebratable {
    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
    }

    public String getBirthdate() {
        return birthdate;
    }

    private void setBirthdate(String birthdate) {
        if (birthdate == null || birthdate.isEmpty()) {
            throw new IllegalArgumentException("Invalid citizen birthday!");
        }
        this.birthdate = birthdate;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid citizen name!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age!");
        }
        this.age = age;
    }

    private void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Invalid id!");
        }
        this.id = id;
    }

    @Override
    public void detain() {
        System.out.println(this.id);
    }


    @Override
    public void printBirthdate() {
        System.out.println(this.birthdate);
    }
}
