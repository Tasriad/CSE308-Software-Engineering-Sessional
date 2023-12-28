package Employees;

import Rules.NotPermittedException;

public class Cashier extends Employee{
    public Cashier(String name)
    {
        super(name, EmployeeType.Cashier);
    }

    @Override
    public boolean canApproveLoan()
    {
        return false;
    }

    @Override
    public boolean canLookup() {
        return true;
    }

    @Override
    public boolean canChangeInterestRate()
    {
        return false;
    }

    @Override
    public boolean canSeeInternalFunds()
    {
        return false;
    }
}
