package System;


import dataStructures.*;

public class AuctionClass implements Auction {
    //voltar gwfbinkwkidwdn
    String auctionId;
    DoubleList<Bid> bids = new DoubleList<>();
    DoubleList<Bid> winningbids = new DoubleList<>();
    DoubleList<Work> works = new DoubleList<>();
    int workcounter = 0;
    int bidcounter = 0;
    DoubleList<User> bidders = new DoubleList<>();


    public AuctionClass(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public void doBid(User buyer, Work work, int value) {
        if (bidders.find(buyer) == -1) {
            bidders.addLast(buyer);
        }
        Bid bid = new BidClass(buyer, value, auctionId, work);
        work.addBid(bid);
        buyer.addBid(bid);
        bidcounter++;
        bids.addLast(bid);
        setWinners(); //quando se dá close talvez
    }

    private void setWinners() {
        int topprice;
        for (int i = 0; i < workcounter; i++) {
            topprice = 0;
            String work = works.get(i).getId();
            for (int x = 0; x < bidcounter; x++) {

                if (work.equals(bids.get(x).getWork().getId())) {
                    if (bids.get(x).getValue() > topprice) {
                        User buyer = bids.get(x).getUser();
                        topprice = bids.get(x).getValue();
                        works.get(i).setLastBuyer(buyer, topprice);

                        //System.out.println(buyer.getAge()+" "+buyer.getLogin()+" "+buyer.getName()+" ");

                    }
                }
            }
        }
    }


    @Override
    public Iterator<Work> closeAuction() {
        //System.out.println("close1");

        for (int i = 0; i < bidders.size(); i++) {
            User bidder = bidders.get(i);
            bidder.eraseBids(auctionId);
        }
        //System.out.println("close2");
        for (int i = 0; i < workcounter; i++) {
            Work work = works.get(i);
            if (work.hasBid()) {
                work.sold();
                work.setLastBuyValue(); //mexer com o auctionId
                work.eraseBids(auctionId);
            }
        }
        return works.iterator();
    }

    @Override
    public void addWork(Work work) {

        works.addLast(work);
        workcounter++;
    }

    @Override
    public boolean hasWork(String workId) {
        return getWork(workId) != null;
    }

    public Work getWork(String workId) {
        for (int i = 0; i < workcounter; i++) {
            Work work1 = works.get(i);
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
    public Iterator<Work> listWorks() {
        return works.iterator();
    }

    @Override
    public Iterator<Bid> listBidsWork(String workId) {
        Work work = getWork(workId);
        return work.listBids();
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
