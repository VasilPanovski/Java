package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d06_square_after;

public class Square extends Shape {
    private double side;

    public void setSide(double side) {

    }

    @Override
    public double area() {
        return this.side * this.side;
    }
}
