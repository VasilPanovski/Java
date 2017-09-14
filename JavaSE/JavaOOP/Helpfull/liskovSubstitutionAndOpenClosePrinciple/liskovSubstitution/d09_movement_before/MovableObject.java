package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d09_movement_before;

import liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d09_movement_before.contracts.Movable;

public abstract class MovableObject implements Movable {

    @Override
    public void move() {
        this.translate();
        this.rotate();
    }

    @Override
    public abstract void rotate();

    @Override
    public abstract void translate();
}
