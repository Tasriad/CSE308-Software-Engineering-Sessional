package Bank;

import Accounts.Account;
import Accounts.FixedDeposit;
import Accounts.Savings;
import Accounts.Student;
import Rules.InvalidAmountException;

public class Portfolio {
    public Account createAccount(String name, String accountType, double initialDeposit) throws InvalidAmountException
    {
        switch (accountType) {
            case "Student":
                System.out.println("Student Account for " + name + " created; initial balance " + initialDeposit + "$");
                return new Student(name, initialDeposit);
            case "Savings":
                System.out.println("Savings Account for " + name + " created; initial balance " + initialDeposit + "$");
                return new Savings(name,initialDeposit);
            case "FixedDeposit":
                FixedDeposit acc = new FixedDeposit(name, initialDeposit);
                if(acc.getBalance()<acc.getAccParam().getInitialDeposit())
                {
                    System.out.println("You need to deposit minimum " + acc.getAccParam().getInitialDeposit() + "$ initially." );
                    return null;
                }
                else
                {
                    System.out.println("Fixed Deposit Account for " + name + " created; initial balance " + initialDeposit + "$");
                    return acc;
                }
            default:
                System.out.println("Invalid Account Type");
                return null;
        }
    }
}
