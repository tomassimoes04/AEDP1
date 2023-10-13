import dataStructures.*;
public interface User {

    String getLogin();

    String getName();

    int getAge();

    String getEmail();
    void addBid(Bid bid);
    boolean hasBids();
    void eraseBids(String auctionId);
}
