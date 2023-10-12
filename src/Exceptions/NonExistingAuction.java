package Exceptions;

public class NonExistingAuction extends Exception{
    public NonExistingAuction(String message) {
        super(message);
    }
}
