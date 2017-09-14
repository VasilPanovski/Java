package pr1_GenericBox;

/**
 * Created by mm on 15.7.2016 г..
 */
public class Box<T> {
    private T type;

    public Box(T type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.type.getClass().getName(), this.type);
    }
}
