package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d10_movement_after;

import liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d09_movement_before.contracts.Movable;

public abstract class MovableObject implements Movable {

    public abstract void translate();

    public abstract void rotate();

    @Override
    public void move() {
        this.translate();
        this.rotate();
    }
}
