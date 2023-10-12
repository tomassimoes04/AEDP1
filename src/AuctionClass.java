import dataStructures.*;

public class AuctionClass implements  Auction{
    //voltar gwfbinkwkidwdn
    String auctionId;
    DoubleList<Bid> bids=new DoubleList<>();
    DoubleList<Bid> winningbids=new DoubleList<>();
    DoubleList<Work>works =new DoubleList<>();
    int workcounter=0;
    int bidcounter=0;


    public AuctionClass(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public void doBid(User buyer, String workId, int value) {
        bids.add(bidcounter,new BidClass(buyer, value, workId));

    }

    @Override
    public Iterator<Bid> closeAuction() {
        return winningbids.iterator();
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
    private Work getWork(String workid){
        for(int i=0;i<workcounter;i++){
            if(works.get(i).getId().equals(workid )){
                return works.get(i);
            }

        }
        return null;
    }

    @Override
    public String getId() {
        return auctionId;
    }

}
