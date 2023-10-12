import dataStructures.Iterator;

public interface Auction {
    void doBid(User buyer,String workId,int value);
    Iterator<Work> closeAuction();
    void addWork(Work work);
    boolean hasWork(String workId);
    String getId();
    Work getWork(String workId);
    boolean isEmpty();
    Iterator<Work> listWorks();
    Iterator<Bid> listBidsWork(String workId);
}
