import java.util.Scanner;
import Bank.Bank;
import Rules.InvalidAmountException;
import Rules.MaturityPeriodException;
import Rules.SameAccountNameException;

public class Main {
    public static void main(String[] args) throws SameAccountNameException, InvalidAmountException, MaturityPeriodException {
        Bank bank = new Bank();
        String activePerson = "";
        String accountName = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String command = scanner.nextLine();
            String[] instructions = command.split(" ");

            switch (instructions[0])
            {
                case "Create":
                    activePerson = instructions[1];
                    bank.createAccount(activePerson,instructions[2],Double.parseDouble(instructions[3]));
                    break;
                case "Deposit":
                    bank.deposit(activePerson,Double.parseDouble(instructions[1]));
                    break;
                case "Withdraw":
                    bank.withdraw(activePerson,Double.parseDouble(instructions[1]));
                    break;
                case "Query":
                    bank.query(activePerson);
                    break;
                case "Request":
                    bank.requestLoan(activePerson,Double.parseDouble(instructions[1]));
                    break;
                case "Close":
                    bank.close(activePerson);
                     activePerson="";
                    break;
                case "Open":
                    activePerson = instructions[1];
                    bank.open(activePerson);
                    break;
                case "Approve":
                    bank.approveLoan(activePerson);
                    break;
                case "Change":
                     bank.changeInterest(activePerson,instructions[1],Double.parseDouble(instructions[2]));
                    break;
                case "Lookup":
                    accountName = instructions[1];
                    bank.lookupAccountBalance(activePerson,accountName);
                    break;
                case "See":
                    bank.seeInternalBalance(activePerson);
                    break;
                case "INC":
                    bank.incrementYear();
                    break;
                default:
                    System.out.println("Invalid Command!");

            }

        }
        scanner.close();
    }
}