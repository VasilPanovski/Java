package pr10_Mood3.models;

import java.lang.*;

public class Demon<Double> extends GameObject {

    public Demon(String userName, String characterType, Double specialPoints) {
        super(userName, characterType, specialPoints);
    }

    @Override
    public String getHashPassword() {
        return String.format("%s", this.getUserName().length() * 217);
    }
}
