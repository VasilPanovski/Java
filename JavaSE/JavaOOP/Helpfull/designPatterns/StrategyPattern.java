package designPatterns;

interface Behavior {
    void moveCommand();
}

class Robot {
    private Behavior behavior;

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public void move() {
        this.behavior.moveCommand();
    }
}

class PassiveBehavior implements Behavior {

    @Override
    public void moveCommand() {
        System.out.println("Standing in place");
    }
}

class AggressiveBehavior implements Behavior {

    @Override
    public void moveCommand() {
        System.out.println("Aggressive!");
    }
}

public class StrategyPattern {

    public static void main(String[] args) {
        Robot robot = new Robot();
        Behavior behavior = new PassiveBehavior();
        robot.setBehavior(behavior);
        robot.move(); // Standing in place

        robot.setBehavior(new AggressiveBehavior());
        robot.move(); // Aggressive
    }
}
