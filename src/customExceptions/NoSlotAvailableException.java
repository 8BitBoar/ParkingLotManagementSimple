package customExceptions;

public class NoSlotAvailableException extends Exception {
    public NoSlotAvailableException (String errorMessage) {
        super(errorMessage);
    }
}
