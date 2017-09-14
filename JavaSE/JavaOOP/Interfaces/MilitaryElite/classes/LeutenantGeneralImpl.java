package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.LeutenantGeneral;
import pr8_MilitaryElite.Interfaces.Private;

import java.util.Collection;

/**
 * Created by mm on 12.7.2016 г..
 */
public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Collection<Private> privates;

    public LeutenantGeneralImpl(String id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

//    @Override
//    public void addPrivate(Soldier privateSoldier) {
//        this.privates.add(privateSoldier);
//    }

    private String getPrivatesToString() {
        StringBuilder sb = new StringBuilder();

        for (Private soldier : privates) {
            sb.append(System.lineSeparator())
            .append("  ")
            .append(soldier.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s%nPrivates:%s", super.toString(), this.getPrivatesToString());

    }
}
