package pr5_BorderControl;

/**
 * Created by mm on 12.7.2016 г..
 */
public class Citizen implements Detainable {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
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
}
