package pr7_FoodShortage;


public class Pet {
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
}
