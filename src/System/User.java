package System;

//interface userModify
import dataStructures.*;

import java.io.Serializable;

public interface User extends Serializable {

    String getLogin();

    String getName();

    int getAge();

    String getEmail();
    void addBid(Bid bid);
    boolean hasBids();
    void eraseBids(String auctionId);
}
