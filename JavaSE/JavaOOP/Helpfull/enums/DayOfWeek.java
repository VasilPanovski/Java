package enums;

/**
 * Created by mm on 27.8.2016 г..
 */
public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class TestEnum {

    public static void main(String[] args) {

        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        System.out.println(DayOfWeek.valueOf("SUNDAY")); // SUNDAY
        int index = dayOfWeek.ordinal(); // 4
    }
}
