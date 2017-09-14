package pr7_FoodShortage;


public class Citizen implements Buyer {
    private static final int FOOD_INCREASES = 10;

    private String name;
    private int age;
    private String id;
    private String birthdate;
    private int food;

    public Citizen(String name, int age, String id, String birthdate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
        food = 0;
    }

    public String getName() {
        return name;
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
    public void buyFood() {
        this.food = FOOD_INCREASES;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
