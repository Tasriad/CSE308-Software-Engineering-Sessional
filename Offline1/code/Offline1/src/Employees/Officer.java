package Employees;

import Rules.NotPermittedException;

public class Officer extends Employee{
    public Officer(String name)
    {
        super(name,EmployeeType.Officer);
    }

    @Override
    public boolean canLookup() {
        return true;
    }

    @Override
    public boolean canApproveLoan()
    {
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
