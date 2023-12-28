package Accounts;

import Rules.InvalidAmountException;

public class Savings extends Account{
    private double minimumBalance;
    public Savings(String name, double initialDeposit)
    {
        super(name,AccountType.Savings,initialDeposit);
        accParam = new AccountParameters(0,10,10,500,0,10000);
        minimumBalance = 1000;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public boolean deposit(double amount) {
        addBalance(amount);
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        substractBalance(amount);
        if(getBalance()<minimumBalance)
        {
            rollbackTransaction(amount);
            System.out.println("Minimum balance present must be " + minimumBalance + "$");
            return false;
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
