package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Mission;

/**
 * Created by mm on 12.7.2016 г..
 */
public class MissionImpl implements Mission {
    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    public void setCodeName(String codeName) {
        if (codeName == null || codeName.isEmpty()) {
            throw new IllegalArgumentException("Invalid code name!");
        }
        this.codeName = codeName;
    }

    public void setState(String state) {
        if (!state.equals("inProgress") && !state.equals("Finished")) {
            throw new IllegalArgumentException("Invalid mission!");
        }

        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        if (this.state.equals("inProgress")) {
            this.setState("Finished");
        }
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
