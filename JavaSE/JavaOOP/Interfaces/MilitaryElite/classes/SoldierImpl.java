package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Soldier;

/**
 * Created by mm on 12.7.2016 г..
 */
public abstract class SoldierImpl implements Soldier {
    private String id;
    private String firstName;
    private String lastName;

    protected SoldierImpl(String id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s",
                this.getFirstName(), this.getLastName(), this.getId());
    }
}
