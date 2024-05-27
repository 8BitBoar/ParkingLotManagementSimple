package customExceptions;

public class InvalidTicketIdException extends Exception {
    public InvalidTicketIdException (String errorMessage) {
        super(errorMessage);
    }
}
