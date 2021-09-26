package ir.airline.service.ExceptionHandling;

public class WrongPasswordException extends RuntimeException {

    //private static final long serialVersionUID = 1L;

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message){
        super(message);
    }
}
