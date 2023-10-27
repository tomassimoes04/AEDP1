package System;


import dataStructures.Iterator;

import java.io.Serializable;

public interface Work extends Serializable {

    String getId();

    String getName();

    int getYear();

    int getLastBuyValue();

    String getBuyerLogin();

    String getBuyerName();

    boolean wasSold();

    int highestBuyValue();

    String getArtistLogin();

    String getArtistName();

    void setMinimumValue(int value);

    int getMinimumValue();

    void notSold();

    void sold();

    void addBid(Bid bid);

    boolean hasBid(String auctionId);

    void setLastBuyValue();

    void eraseBids(String auctionId);

    Iterator<Bid> listBids(String auctionId);
    void setLastBuyer(User winner,int value);
}
