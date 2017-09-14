package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d06_square_after;

public class Rectangle extends Shape {
    private double width;
    private double height;

    private void setWidth(double width) {
        this.width = width;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}
