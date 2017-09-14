package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d10_movement_after;

import liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d10_movement_after.contracts.Rotatable;

public abstract class RotatableObject implements Rotatable {

    public abstract void rotate();

    @Override
    public void move() {
        this.rotate();
    }
}
