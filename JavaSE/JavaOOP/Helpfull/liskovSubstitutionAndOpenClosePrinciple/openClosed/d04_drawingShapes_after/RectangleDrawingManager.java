package liskovSubstitutionAndOpenClosePrinciple.openClosed.d04_drawingShapes_after;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before.contracts.Shape;

public class RectangleDrawingManager extends DrawingManager {

    @Override
    protected void drawFigure(Shape shape) {
        Rectangle rectangle = (Rectangle) shape;

        // Draw rectangle
    }
}
