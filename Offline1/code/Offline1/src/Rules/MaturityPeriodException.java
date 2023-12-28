package Rules;

public class MaturityPeriodException extends Exception{
    public MaturityPeriodException()
    {
        super("Your account has not reached a maturity period of one year!");
    }
}
