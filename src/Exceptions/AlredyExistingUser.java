package Exceptions;

public class AlredyExistingUser extends Exception{
    public AlredyExistingUser(String message) {
        super(message);
    }
}
