package pr3_Ferrari;

/**
 * Created by mm on 11.7.2016 г..
 */
public class Ferrari implements Car {
    private static final String PEDAL_MESSAGE = "Zadu6avam sA!/";
    private static final String BRAKES_MESSAGE = "/Brakes!/";

    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }


    @Override
    public String useBrakes() {
        return BRAKES_MESSAGE;
    }

    @Override
    public String pushTheGasPedal() {
        return PEDAL_MESSAGE;
    }

    @Override
    public String toString() {
        return MODEL + this.useBrakes() + this.pushTheGasPedal() + this.driverName;
    }
}
