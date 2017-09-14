package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d09_movement_before;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RotatableObject extends MovableObject {

    @Override
    public void rotate() {
        // do rotation logic
    }

    @Override
    public void translate() {
        throw new NotImplementedException();
    }

    @Override
    public void move() {
        this.rotate();
    }
}
