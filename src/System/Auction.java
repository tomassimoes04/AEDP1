package System;


import dataStructures.Iterator;

import java.io.Serializable;

public interface Auction extends Serializable {
    void doBid(User buyer,Work work,int value);
    Iterator<Work> closeAuction();
    void addWork(Work work);
    boolean hasWork(String workId);
    String getId();
    Work getWork(String workId);
    boolean isEmpty();
    Iterator<Work> listWorks();
    Iterator<Bid> listBidsWork(String workId);
}
