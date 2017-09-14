package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d09_movement_before;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TranslatableObject extends MovableObject {

    @Override
    public void rotate() {
        throw new NotImplementedException();
    }

    @Override
    public void translate() {
        // do translation logic
    }

    @Override
    public void move() {
        this.translate();
    }
}
