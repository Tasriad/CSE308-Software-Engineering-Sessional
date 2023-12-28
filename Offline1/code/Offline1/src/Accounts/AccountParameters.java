package Accounts;

public class AccountParameters {
    private int maturityPeriod;
    private double loanInterestRate;
    private double depositInterestRate;
    private double yearlyDeduction;

    private double initialDeposit;

    private double maximumAllowableLoan;

    public AccountParameters(int maturityPeriod, double loanInterestRate, double depositInterestRate, double yearlyDeduction, double initialDeposit,double maximumAllowableLoan) {
        this.maturityPeriod = maturityPeriod;
        this.loanInterestRate = loanInterestRate;
        this.depositInterestRate = depositInterestRate;
        this.yearlyDeduction = yearlyDeduction;
        this.initialDeposit = initialDeposit;
        this.maximumAllowableLoan = maximumAllowableLoan;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public double getDepositInterestRate() {
        return depositInterestRate;
    }

    public void setDepositInterestRate(double depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
    }

    public double getYearlyDeduction() {
        return yearlyDeduction;
    }

    public void setYearlyDeduction(double yearlyDeduction) {
        this.yearlyDeduction = yearlyDeduction;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public double getMaximumAllowableLoan() {
        return maximumAllowableLoan;
    }

    public void setMaximumAllowableLoan(double maximumAllowableLoan) {
        this.maximumAllowableLoan = maximumAllowableLoan;
    }
}
