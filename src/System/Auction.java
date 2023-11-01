package System;


import dataStructures.Iterator;

import java.io.Serializable;

public interface Auction extends Serializable {


    /**
     * Check if a work with the given ID exists.
     * @param workId - The ID of the work to be checked.
     * @return true if a work with the provided ID exists, otherwise false.
     */
    boolean hasWork(String workId);

    /**
     * Get the ID of the current object.
     * @return A string representing the ID of the current object.
     */
    String getId();

    /**
     * Check if the current object is empty.
     * @return true if the object is empty, otherwise false.
     */
    boolean isEmpty();

    /**
     * Get an iterator for listing all works associated with the current object.
     * @return Iterator of WorkClass for listing works.
     */
    Iterator<WorkClass> listWorks();

    /**
     * Get an iterator for listing bids on a specific work.
     * @param workId - The ID of the work for which bids should be listed.
     * @return Iterator of Bid for listing bids on the specified work.
     */
    Iterator<Bid> listBidsWork(String workId);

    /**
     * Check if a user or artist has works associated with them in an auction.
     * @param login - The user's or artist's login to check for works.
     * @return true if the user or artist has works in an auction, otherwise false.
     */
    boolean hasWorksInAuction(String login);

}
