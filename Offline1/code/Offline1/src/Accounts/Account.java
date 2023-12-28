package Accounts;

import Rules.InvalidAmountException;
import Rules.MaturityPeriodException;


public abstract class Account {
    private String accountName;
    private AccountType type;
    private double balance;
    private double loanAmount;
    private int accountAge;
    protected AccountParameters accParam;

    public Account(String accountName, AccountType type, double initialDeposit) {
        this.accountName = accountName;
        this.type = type;
        this.balance = initialDeposit;
        this.loanAmount = 0;
        this.accountAge = 0;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(int accountAge) {
        this.accountAge = accountAge;
    }

    public AccountParameters getAccParam() {
        return accParam;
    }

    public void setAccParam(AccountParameters accParam) {
        this.accParam = accParam;
    }

    public void addBalance(double balance)
    {
        this.balance+=balance;
    }
    public boolean substractBalance(double balance)
    {
        if(balance>this.balance)
        {
            return false;
        }
        else
        {
            this.balance-=balance;
            return true;
        }
    }
    public void addLoan(double loan)
    {
        this.loanAmount+=loan;
    }
    public void substractLoan(double loan) throws InvalidAmountException
    {
        if(loan>this.loanAmount)
        {
            throw new InvalidAmountException("Amount of loan cannot be negative");
        }
    }
    public void rollbackTransaction(double amount)
    {
        addBalance(amount);
    }
    public void queryDeposit()
    {
        if(loanAmount==0)
        {
            System.out.println("Current Balance " + getBalance() + "$");
        }
        else
        {
            System.out.println("Current Balance " + getBalance() + "$, loan " + getLoanAmount() + "$");
        }
    }
    public abstract boolean deposit(double amount) throws InvalidAmountException;
    public abstract boolean withdraw(double amount) throws InvalidAmountException, MaturityPeriodException;
    public abstract boolean requestLoan(double amount) throws InvalidAmountException;

}
