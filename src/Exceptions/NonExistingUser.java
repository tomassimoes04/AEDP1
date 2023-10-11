package Exceptions;

public class NonExistingUser extends Exception{
    public NonExistingUser(String message) {
        super(message);
    }
}
