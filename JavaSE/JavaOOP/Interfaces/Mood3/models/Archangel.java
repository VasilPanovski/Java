package pr10_Mood3.models;

public class Archangel<Integer> extends GameObject {

    public Archangel(String userName, String characterType, Integer specialPoints) {
        super(userName, characterType, specialPoints);
    }

    @Override
    public String getHashPassword() {
        return new StringBuilder(this.getUserName()).reverse().toString() + (this.getUserName().length() * 21);
    }
}
