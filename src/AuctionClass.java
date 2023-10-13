import dataStructures.*;

public class AuctionClass implements  Auction{
    //voltar gwfbinkwkidwdn
    String auctionId;
    DoubleList<Bid> bids=new DoubleList<>();
    DoubleList<Bid> winningbids=new DoubleList<>();
    DoubleList<Work>works =new DoubleList<>();
    int workcounter=0;
    int bidcounter=0;
    DoubleList<User> bidders = new DoubleList<>();


    public AuctionClass(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public void doBid(User buyer, Work work, int value) {
        if (bidders.find(buyer)==-1){
            bidders.addLast(buyer);
        }
        Bid bid = new BidClass(buyer, value, auctionId);
        work.addBid(bid);
        buyer.addBid(bid);
    }

    @Override
    public Iterator<Work> closeAuction() {
        for (int i = 0; i<bidders.size(); i++){
            User bidder = bidders.get(i);
            bidder.eraseBids(auctionId);
        }
        for (int i = 0; i< workcounter; i++){
            Work work = works.get(i);
            if (work.hasBid()){
                work.sold();
                work.setLastBuyValue(); //mexer com o auctionId
                work.eraseBids(auctionId);
            }
        }
        return works.iterator();
    }

    @Override
    public void addWork(Work work) {
        workcounter++;
        works.add(workcounter,work);
    }

    @Override
    public boolean hasWork(String workId) {
       return getWork(workId)!=null;
    }
    public Work getWork(String workid){
        for(int i=0;i<workcounter;i++){
            if(works.get(i).getId().equals(workid )){
                return works.get(i);
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
    public String getId() {
        return auctionId;
    }



}
