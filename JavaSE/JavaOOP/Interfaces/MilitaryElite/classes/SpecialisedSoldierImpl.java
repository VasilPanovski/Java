package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.SpecialisedSoldier;

/**
 * Created by mm on 12.7.2016 г..
 */
public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private String corps;

    public SpecialisedSoldierImpl(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if (!corps.equals("Airforces") && !corps.equals("Marines")) {
            throw new IllegalArgumentException("Invalid input for corps!");
        }
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
}
