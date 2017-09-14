package designPatterns;

interface Employee {

    void setSuccessor(Employee successor);
    void processRequest(LoanRequest request);
}



class LoanRequest {
    private int amount;
    private String purpose;

    public LoanRequest(int amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getPurpose() {
        return this.purpose;
    }
}

abstract class BankEmployee implements Employee {
    private Employee successor;

    abstract String getRole();
    abstract int getAllowable();


    @Override
    public void setSuccessor(Employee successor) {
        this.successor = successor;
    }

    @Override
    public void processRequest(LoanRequest request) {
        if (request.getAmount() <= this.getAllowable()) {
            System.out.println(this.getRole() + " approved the request!");
        } else if (this.successor != null) {
            this.successor.processRequest(request);
        }
    }
}

class Clerk extends BankEmployee {

    @Override
    String getRole() {
        return "Clerk";
    }

    @Override
    int getAllowable() {
        return 10_000;
    }
}

class LocalManager extends BankEmployee {

    @Override
    String getRole() {
        return "Local manager";
    }

    @Override
    int getAllowable() {
        return 100_000;
    }
}

public class ChainOfResponsibility {

    public static void main(String[] args) {
        BankEmployee clerk = new Clerk();
        BankEmployee manager = new LocalManager();

        LoanRequest request = new LoanRequest(26000, "studies");
        clerk.setSuccessor(manager);
        clerk.processRequest(request);
    }
}
