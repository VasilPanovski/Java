package liskovSubstitutionAndOpenClosePrinciple.openClosed.d04_drawingShapes_after;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d03_drawingShapes_before.contracts.Shape;

public class CircleDrawingManager extends DrawingManager {

    @Override
    protected void drawFigure(Shape shape) {
        Circle circle = (Circle) shape;

        // Draw circle
    }
}
