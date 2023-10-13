import dataStructures.Iterator;

public interface Work {

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

    boolean hasBid();

    void setLastBuyValue();

    void eraseBids(String auctionId);

    Iterator<Bid> listBids();
}
