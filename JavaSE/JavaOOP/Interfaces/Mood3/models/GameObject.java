package pr10_Mood3.models;

import pr10_Mood3.interfaces.Hashable;

public abstract class GameObject<T> implements Hashable {
    private String userName;
    private String characterType;
    private T specialPoints;
    private int level;

    public GameObject(String userName, String characterType, T specialPoints) {
        this.setUserName(userName);
        this.characterType = characterType;
        this.specialPoints = specialPoints;
    }

    private void setUserName(String userName) {
        if (userName.length() > 10 || userName.matches("\\d")) {
            throw new IllegalArgumentException("Invalid user name!");
        }
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n",
                this.getUserName(),
                this.getHashPassword(),
                this.getCharacterType());
    }
}
