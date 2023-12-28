package Rules;

public class NotPermittedException extends Exception{
    public NotPermittedException()
    {
        super("You don't have permission for this operation.");
    }
}
