package liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before.contracts.Drawer;
import liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before.contracts.Shape;

public class DrawingManager implements Drawer {

    public void draw(Shape shape) {
        if (shape instanceof Circle) {
            this.drawCircle((Circle) shape);
        }
        else if (shape instanceof Rectangle) {
            this.drawRectangle((Rectangle) shape);
        }
    }

    private void drawRectangle(Rectangle rectangle) {
    }

    private void drawCircle(Circle circle) {
    }
}
