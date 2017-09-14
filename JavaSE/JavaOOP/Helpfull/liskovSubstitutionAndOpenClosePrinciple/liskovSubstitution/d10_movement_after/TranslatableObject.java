package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d10_movement_after;

import liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d10_movement_after.contracts.Translatable;

public abstract class TranslatableObject implements Translatable {

    public abstract void translate();

    public void move() {
        this.translate();
    }
}
