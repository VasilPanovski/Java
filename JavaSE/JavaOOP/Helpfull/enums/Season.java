package enums;

import static enums.Season.SUMMER;

public enum Season {
    SPRING("warm", 20),
    SUMMER("hot", 30),
    AUTUMN("rainy", 21),
    WINTER("cold", 0);

    String description;
    int averageDegrease;

    Season(String description, int averageDegrease) {
        this.description = description;
        this.averageDegrease = averageDegrease;
    }

    public String getDescription() {
        return this.description;
    }

    public int getAverageDegrease() {
        return this.averageDegrease;
    }
}

class TestSeasonEnum {

    public static void main(String[] args) {

        Season season = SUMMER;
        System.out.printf("Season: %s%nDescription: %s, %s degrease",
                season.name(),
                season.getDescription(),
                season.getAverageDegrease());

        Enum summer = Enum.valueOf(Season.class, "SUMMER"); // SUMMER
        summer = Season.valueOf("SUMMER"); // SUMMER

    }
}
