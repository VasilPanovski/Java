package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Commando;
import pr8_MilitaryElite.Interfaces.Mission;

import java.util.Collection;

/**
 * Created by mm on 12.7.2016 г..
 */
public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;

    public CommandoImpl(String id, String firstName, String lastName, double salary, String corp, Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corp);
        this.missions = missions;
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    private String getMissionsToString() {
        StringBuilder sb = new StringBuilder();

        for (Mission mission : missions) {
            sb.append(System.lineSeparator())
                    .append("  ")
                    .append(mission.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Missions:")
                .append(getMissionsToString());

        return sb.toString();
    }
}
