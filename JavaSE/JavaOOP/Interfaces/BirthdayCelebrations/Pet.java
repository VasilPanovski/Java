package pr6_BirthdayCelebrations;

/**
 * Created by mm on 12.7.2016 г..
 */
public class Pet implements BirthdayCelebratable {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid pet name!");
        }
        this.name = name;
    }

    private void setBirthdate(String birthdate) {
        if (birthdate == null || birthdate.isEmpty()) {
            throw new IllegalArgumentException("Invalid pet birthday");
        }
        this.birthdate = birthdate;
    }

    @Override
    public void printBirthdate() {
        System.out.println(this.birthdate);
    }
}
