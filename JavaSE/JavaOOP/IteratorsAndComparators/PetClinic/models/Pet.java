package pr8_PetClinic.models;

/**
 * Created by mm on 24.7.2016 г..
 */
public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.kind);
    }
}
