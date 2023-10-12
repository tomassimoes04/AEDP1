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

    void addBid(User buyer, int value);

    boolean hasBid();

    void setLastBuyValue();

    void eraseBids();

    Iterator<Bid> listBids();
}
