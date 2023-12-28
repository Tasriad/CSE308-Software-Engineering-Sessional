package Employees;

import Rules.NotPermittedException;

public abstract class Employee {
    private String name;
    protected EmployeeType type;

    public Employee(String name,EmployeeType type)
    {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public EmployeeType getType() {
        return type;
    }

    public abstract boolean canLookup();
    public abstract boolean canApproveLoan() ;
    public abstract boolean canChangeInterestRate();
    public abstract boolean canSeeInternalFunds();
}
