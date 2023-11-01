package System;


import dataStructures.*;

public class AuctionClass implements Auction {

    String auctionId;
    DoubleList<Bid> bids = new DoubleList<>();

    DoubleList<WorkClass> works = new DoubleList<>();
    int workcounter = 0;
    int bidcounter = 0;
    DoubleList<UserClass> bidders = new DoubleList<>();


    public AuctionClass(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof AuctionClass)) {
            return false;
        }

        AuctionClass a = (AuctionClass) o;

        return auctionId.equals(a.getId());
    }

    /**
     * Perform a bid in the auction.
     *
     * @param buyer - The user making the bid.
     * @param work - The work for which the bid is placed.
     * @param value - The bid value.
     */
    protected void doBid(UserClass buyer, Work work, int value) {
        if (bidders.find(buyer) == -1) {
            bidders.addLast(buyer);
        }
        Bid bid = new BidClass(buyer, value, auctionId, work);
        work.addBid(bid);
        buyer.addBid(bid);
        bidcounter++;
        bids.addLast(bid);
    }

    /**
     * Method to set the winners of the auction
     */

    private void setWinners() {
        for (int i = 0; i< works.size(); i++){
            Work work = works.get(i);
            Bid bid = work.getHighestBid(auctionId);
            work.setLastBuyer(bid.getUser(), 0);
        }
    }

    /**
     * Method to close the auction
     * @return work-iterator
     */

    protected Iterator<WorkClass> closeAuction() {
        setWinners();
        for (int i = 0; i < bidders.size(); i++) {
            UserClass bidder = bidders.get(i);
            bidder.eraseBids(auctionId);
        }
        for (int i = 0; i < workcounter; i++) {
            WorkClass work = works.get(i);
            if (work.hasBid(auctionId)) {
                work.sold();
                work.setLastBuyValue(auctionId);
                work.eraseBids(auctionId);
            }
        }
        return works.iterator();
    }

    /**
     * Method to add a work to the auction
     * @param work -The ID a new work that will be added to the auction.
     */
    protected void addWork(WorkClass work) {

        works.addLast(work);
        workcounter++;
    }

    @Override
    public boolean hasWork(String workId) {
        return getWork(workId) != null;
    }

    /**
     * Method to return a work
     * @param workId - The ID of the desired work.
     * @return work
     */
    protected WorkClass getWork(String workId) {
        for (int i = 0; i < workcounter; i++) {
            WorkClass work1 = works.get(i);
            if (work1.getId().equals(workId)) {
                return work1;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return works.isEmpty();
    }

    @Override
    public Iterator<WorkClass> listWorks() {
        return works.iterator();
    }

    @Override
    public Iterator<Bid> listBidsWork(String workId) {
        Work work = getWork(workId);
        return work.listBids(auctionId);
    }

    @Override
    public boolean hasWorksInAuction(String login) {
        for (int i = 0; i<works.size(); i++){
            Work work = works.get(i);
            if (work.getArtistLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getId() {
        return auctionId;
    }


}
