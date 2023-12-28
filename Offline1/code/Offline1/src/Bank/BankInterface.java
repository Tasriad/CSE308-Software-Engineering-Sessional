package Bank;

import Rules.InvalidAmountException;
import Rules.MaturityPeriodException;
import Rules.SameAccountNameException;

public interface BankInterface {
     void createAccount(String name, String accountType, double initialDeposit) throws SameAccountNameException, InvalidAmountException;
     void open(String name);
     void close(String name);
     void deposit(String name, double amount) throws InvalidAmountException;
     void withdraw(String name, double amount) throws MaturityPeriodException, InvalidAmountException;
     void query(String name);
     void requestLoan(String name, double amount) throws InvalidAmountException;
     void approveLoan(String name);
    void changeInterest(String employeeName,String accountType,double newRate);
    void lookupAccountBalance(String employeeName,String accountName);
    void seeInternalBalance(String employeeName);
    void incrementYear();
}
