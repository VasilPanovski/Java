package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Repair;

/**
 * Created by mm on 12.7.2016 г..
 */
public class RepairImpl implements Repair {
    private String partName;
    private int workedHours;

    public RepairImpl(String partName, int workedHours) {
        this.setPartName(partName);
        this.setWorkedHours(workedHours);
    }

    public void setPartName(String partName) {
        if (partName == null || partName.isEmpty()) {
            throw new IllegalArgumentException("Invalid part name!");
        }
        this.partName = partName;
    }

    public void setWorkedHours(int workedHours) {
        if (workedHours < 0) {
            throw new IllegalArgumentException("Invalid worked hours!");
        }
        this.workedHours = workedHours;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getWorkedHours() {
        return this.workedHours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getWorkedHours());
    }
}
