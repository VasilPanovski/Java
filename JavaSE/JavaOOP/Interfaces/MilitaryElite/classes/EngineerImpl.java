package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Engineer;
import pr8_MilitaryElite.Interfaces.Repair;

import java.util.Collection;

/**
 * Created by mm on 12.7.2016 г..
 */
public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(String id, String firstName, String lastName, double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    private String getRepairsToString() {
        StringBuilder sb = new StringBuilder();

        for (Repair repair : repairs) {
            sb.append(System.lineSeparator())
                    .append("  ")
                    .append(repair.toString());

        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(getRepairsToString());

        return sb.toString();
    }
}
