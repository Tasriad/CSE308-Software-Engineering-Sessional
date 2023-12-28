package Employees;

public class ManagingDirector extends Employee{

    public ManagingDirector(String name) {
        super(name,EmployeeType.ManagingDirector);
    }

    @Override
    public boolean canLookup() {
        return true;
    }
    @Override
    public boolean canApproveLoan() {
        return true;
    }

    @Override
    public boolean canChangeInterestRate() {
        return true;
    }

    @Override
    public boolean canSeeInternalFunds() {
        return true;
    }
}
