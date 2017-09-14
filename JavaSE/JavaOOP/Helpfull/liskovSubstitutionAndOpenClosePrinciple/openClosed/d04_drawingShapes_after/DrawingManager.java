package liskovSubstitutionAndOpenClosePrinciple.openClosed.d04_drawingShapes_after;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before.contracts.Drawer;
import liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before.contracts.Shape;

public abstract class DrawingManager implements Drawer {

    @Override
    public void draw(Shape shape) {
        this.drawFigure(shape);
    }

    protected abstract void drawFigure(Shape shape);
}
