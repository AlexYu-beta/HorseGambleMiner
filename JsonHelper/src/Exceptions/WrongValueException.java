package Exceptions;

/**
 * Created by alex on 3/14/17.
 */
public class WrongValueException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Wrong input value has been found.";
    }
}
