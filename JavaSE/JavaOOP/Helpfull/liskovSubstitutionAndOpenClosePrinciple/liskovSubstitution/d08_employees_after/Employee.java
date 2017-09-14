package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d08_employees_after;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}
