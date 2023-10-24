package System;


import java.io.Serializable;

public interface Bid extends Serializable {
    String getBuyerLogin();
    String getBuyerName();
    int getValue();
    String getAuctionId();
    User getUser();
    Work getWork();
}
