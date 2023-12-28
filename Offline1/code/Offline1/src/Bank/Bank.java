package Bank;

import Accounts.Account;
import Employees.Employee;
import Employees.EmployeeType;
import Rules.InvalidAmountException;
import Rules.MaturityPeriodException;
import Rules.SameAccountNameException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank implements BankInterface{
    private double internalFund;
    private int clock;
    private Map<String, Account> accounts;
    private Map<Account,Double> pendingLoan;
    private Map<String, Employee> employees;
    private Portfolio portfolio;
    private Personnel personnel;

    public Bank()
    {
        this.internalFund = 1000000;
        this.clock = 0;
        portfolio = new Portfolio();
        personnel = new Personnel();
        accounts = new HashMap<>();
        pendingLoan = new HashMap<>();
        employees = new HashMap<>();

        employees.put("MD", personnel.appoint("MD", EmployeeType.ManagingDirector));
        for (int i = 1; i <= 2; i++) {
            employees.put("O" + i, personnel.appoint("O" + i,EmployeeType.Officer));
        }
        for (int i = 1; i <= 5; i++) {
            employees.put("C" + i, personnel.appoint("C" + i,EmployeeType.Cashier));
        }
        System.out.println("Bank created; MD, O1, O2, C1, C2, C3, C4, C5 created");

    }

    public double getInternalFund() {
        return internalFund;
    }
    private void incrementAccountAge()
    {
        for (String accName : accounts.keySet())
        {
            Account acc = accounts.get(accName);
            acc.setAccountAge(acc.getAccountAge()+1);
        }
    }
    private void serviceFee()
    {
        for (String accName : accounts.keySet())
        {
            Account acc = accounts.get(accName);
            double currentBalance = acc.getBalance();
            double deduction = acc.getAccParam().getYearlyDeduction();
            if(currentBalance>deduction)
            {
                acc.setBalance(currentBalance-deduction);
            }
        }
    }
    private double calculateInterestAmount(double amount, double interest)
    {
        return (amount * interest)/100;
    }
    private void loanInterestCollection()
    {
        for (String accName : accounts.keySet())
        {
            Account acc = accounts.get(accName);
            double currentBalance = acc.getBalance();
            double loan = acc.getLoanAmount();
            double interest = acc.getAccParam().getLoanInterestRate();
            double deduction = calculateInterestAmount(loan,interest);
            if(currentBalance>deduction)
            {
                acc.setBalance(currentBalance-deduction);
            }
        }
    }
    private void depositInterest()
    {
        for (String accName : accounts.keySet())
        {
            Account acc = accounts.get(accName);
            double currentBalance = acc.getBalance();
            double interest = acc.getAccParam().getDepositInterestRate();
            double interestAmount = calculateInterestAmount(currentBalance,interest);
            acc.setBalance(currentBalance+interestAmount);
        }
    }

    public void createAccount(String name, String accountType, double initialDeposit) throws SameAccountNameException, InvalidAmountException {
        if(accounts.containsKey(name))
        {
            throw new SameAccountNameException();
        }
        Account account = portfolio.createAccount(name,accountType,initialDeposit);
        if (account != null) {
            accounts.put(name, account);
        }
        else
        {
            System.out.println("Account creation failed!");
        }
    }
    public void open(String name)
    {
        if (accounts.containsKey(name))
        {
            System.out.println("Welcome back, " + name);
        } else if (employees.containsKey(name)) {
            System.out.println(name + " active, there are loan approvals pending");
        }
        else
        {
            System.out.println("Not account holder nor an Employee");
        }
    }
    public void close(String name)
    {
        if (accounts.containsKey(name))
        {
            System.out.println("Transaction closed for " + name);
        } else if (employees.containsKey(name)) {
            System.out.println("Operations for " + name + " closed");
        }
    }
    public void deposit(String name, double amount) throws InvalidAmountException {
        Account account = accounts.get(name);
        if (account != null) {
            boolean success = account.deposit(amount);
            if(success)
            {
                System.out.println(amount + "$ deposited; current balance " + account.getBalance() + "$");
            }
            else
            {
                System.out.println("Invalid transaction; current balance " + account.getBalance() + "$");
            }
        }
        else
        {
            System.out.println("Not a valid account holder!");
        }
    }
    public void withdraw(String name, double amount) throws MaturityPeriodException, InvalidAmountException {
        Account account = accounts.get(name);
        if (account != null) {
            boolean success = account.withdraw(amount);
            if(success)
            {
                System.out.println(amount + "$ withdrawn; current balance " + account.getBalance() + "$");
            }

        } else {
            System.out.println("Not a valid account holder!");
        }
    }
    public void query(String name)
    {
         Account account = accounts.get(name);
         if(account!=null)
         {
             account.queryDeposit();
         }
         else
         {
             System.out.println("Not a valid account holder!");
         }
    }
    public void requestLoan(String name, double amount) throws InvalidAmountException {
        Account account = accounts.get(name);
        if (account != null) {
            if(account.requestLoan(amount))
            {
                pendingLoan.put(account, amount);
                System.out.println("Loan request successful; sent for approval");
            }
            else
            {
                System.out.println("Loan request unsuccessful!");
            }
        } else {
            System.out.println("Not a valid account holder!");
        }
    }
    public void approveLoan(String name) {
        if (employees.containsKey(name)) {
            Employee employee = employees.get(name);
            if (employee.canApproveLoan()) {
                Iterator<Map.Entry<Account, Double>> iterator = pendingLoan.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Account, Double> entry = iterator.next();
                    Account account = entry.getKey();
                    account.addBalance(entry.getValue());
                    account.addLoan(entry.getValue());
                    iterator.remove();  // Use iterator to remove the entry
                    System.out.println("Loan for " + account.getAccountName() + " approved");
                }
            } else {
                System.out.println("You don't have permission for this operation!");
            }
        } else {
            System.out.println("Not a valid employee!");
        }
    }

    public void changeInterest(String employeeName,String accountType,double newRate) {
        if (employees.containsKey(employeeName)) {
            Employee employee = employees.get(employeeName);
            if(employee.canChangeInterestRate())
            {
                    for (String accountName : accounts.keySet()) {
                        Account acc = accounts.get(accountName);
                        if(String.valueOf(acc.getType()).matches(accountType) )
                        {
                            acc.getAccParam().setDepositInterestRate(newRate);
                        }
                    }
            } else {
                System.out.println("You don't have permission for this operation!");
            }
        }
        else
        {
            System.out.println("Not a valid employee!");
        }
    }
    public void lookupAccountBalance(String employeeName,String accountName)
    {
        if (employees.containsKey(employeeName)) {
            Employee employee = employees.get(employeeName);
            if(employee.canLookup())
            {
                Account account = accounts.get(accountName);
                System.out.println(accountName + "'s current balance " + account.getBalance() + "$");
            } else {
                System.out.println("You don't have permission for this operation!");
            }
        }
        else
        {
            System.out.println("Not a valid employee!");
        }
    }
    public void seeInternalBalance(String employeeName)
    {
        if (employees.containsKey(employeeName)) {
            Employee employee = employees.get(employeeName);
            if(employee.canSeeInternalFunds())
            {
                System.out.println("Internal Fund " + getInternalFund() + "$");
            } else {
                System.out.println("You don't have permission for this operation!");
            }
        }
        else
        {
            System.out.println("Not a valid employee!");
        }
    }
    public void incrementYear()
    {
        clock++;
        System.out.println("1 year passed");
        incrementAccountAge();
        serviceFee();
        depositInterest();
        loanInterestCollection();
    }

}
