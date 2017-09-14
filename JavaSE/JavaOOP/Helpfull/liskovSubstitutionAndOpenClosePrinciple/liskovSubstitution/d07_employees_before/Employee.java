package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d07_employees_before;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }
}
