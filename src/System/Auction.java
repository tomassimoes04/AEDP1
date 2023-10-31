package System;


import dataStructures.Iterator;

import java.io.Serializable;

public interface Auction extends Serializable {
    void doBid(UserClass buyer,Work work,int value);
    Iterator<WorkClass> closeAuction();
    void addWork(WorkClass work);
    boolean hasWork(String workId);
    String getId();
    Work getWork(String workId);
    boolean isEmpty();
    Iterator<WorkClass> listWorks();
    Iterator<Bid> listBidsWork(String workId);

    boolean hasWorksInAuction(String login);
}
