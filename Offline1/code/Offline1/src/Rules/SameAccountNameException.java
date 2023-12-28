package Rules;

public class SameAccountNameException extends Exception{
    public SameAccountNameException()
    {
        super("Account already exists!");
    }
}
