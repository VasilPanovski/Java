package liskovSubstitutionAndOpenClosePrinciple.liskovSubstitution.d07_employees_before;

public class Manager extends Employee {

    private Iterable<String> documents;

    private Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }
}
