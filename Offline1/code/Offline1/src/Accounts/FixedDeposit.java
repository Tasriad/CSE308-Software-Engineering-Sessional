package Accounts;

import Rules.InvalidAmountException;
import Rules.MaturityPeriodException;

public class FixedDeposit extends Account{
    private double minimumDeposit;
    public FixedDeposit(String name, double initialDeposit)
    {
        super(name,AccountType.FixedDeposit,initialDeposit);
        accParam = new AccountParameters(1,10,15,500,100000,100000);
    }

    public double getMinimumDeposit() {
        return minimumDeposit;
    }

    public void setMinimumDeposit(double minimumDeposit) {
        this.minimumDeposit = minimumDeposit;
    }

    @Override
    public boolean deposit(double amount) throws InvalidAmountException {
        if(amount<minimumDeposit)
        {
            throw new InvalidAmountException("Minimum deposit must be " + minimumDeposit + "$");
        }
        else
        {
            addBalance(amount);
            return true;
        }
    }

    @Override
    public boolean withdraw(double amount) throws MaturityPeriodException,InvalidAmountException {
        if( getAccountAge()<accParam.getMaturityPeriod())
        {
            throw new MaturityPeriodException();
        } else if (!substractBalance(amount)) {
            throw new InvalidAmountException("Withdrawal amount surpasses the balance present.");
        }
        return true;
    }

    @Override
    public boolean requestLoan(double amount) throws InvalidAmountException {
        if(amount>accParam.getMaximumAllowableLoan())
        {
            throw new InvalidAmountException("The requesting amount should be less than " + accParam.getMaximumAllowableLoan() + "$");
        }
        else
        {
            return true;
        }
    }
}
