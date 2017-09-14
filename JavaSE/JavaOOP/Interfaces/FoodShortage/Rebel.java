package pr7_FoodShortage;

public class Rebel implements Buyer {
    private static final int FOOD_INCREASES = 5;

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
        food = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid rebel name!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid rebel age!");
        }
        this.age = age;
    }

    public void setGroup(String group) {
        if (group == null || group.isEmpty()) {
            throw new IllegalArgumentException("Invalid rebel group!");
        }
        this.group = group;
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
