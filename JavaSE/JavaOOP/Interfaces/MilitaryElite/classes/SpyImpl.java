package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Spy;

/**
 * Created by mm on 12.7.2016 г..
 */
public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Code Number: ")
                .append(this.getCodeNumber())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
