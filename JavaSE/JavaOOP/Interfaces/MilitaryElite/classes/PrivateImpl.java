package pr8_MilitaryElite.classes;

import pr8_MilitaryElite.Interfaces.Private;

/**
 * Created by mm on 12.7.2016 г..
 */
public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Invalid salary!");
        }
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.getSalary());
    }
}
