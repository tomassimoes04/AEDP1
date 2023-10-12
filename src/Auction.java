import dataStructures.Iterator;

public interface Auction {
    void doBid(User buyer,String workId,int value);
    Iterator<Bid> closeAuction();
    void addWork(Work work);
    boolean hasWork(String workId);
    String getId();

}
