package Accounts;

import Rules.InvalidAmountException;

public class Student extends Account{
    private double maximumWithdrawalAmount;
    public Student(String name, double initialDeposit)
    {
        super(name,AccountType.Student,initialDeposit);
        accParam = new AccountParameters(0,10,5,0,0,1000);
        maximumWithdrawalAmount = 10000;
    }

    public double getMaximumWithdrawalAmount() {
        return maximumWithdrawalAmount;
    }

    public void setMaximumWithdrawalAmount(double maximumWithdrawalAmount) {
        this.maximumWithdrawalAmount = maximumWithdrawalAmount;
    }

    @Override
    public boolean deposit(double amount) {
        addBalance(amount);
        return true;
    }

    @Override
    public boolean withdraw(double amount) throws InvalidAmountException {
        if(!substractBalance(amount))
        {
            throw new InvalidAmountException("Withdrawal amount surpasses the balance present.");
        } else if (amount>maximumWithdrawalAmount) {
            rollbackTransaction(amount);
            System.out.println("Invalid transaction; current balance " + getBalance() + "$" );
            return false;
        }
        return true;
    }

    @Override
    public boolean requestLoan(double amount) throws InvalidAmountException{
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
