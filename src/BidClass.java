public class BidClass implements Bid{

    private User buyer;
    private int value;
    private Work work;
    private String auctionId;

    public BidClass (User buyer, int value, String auctionId,Work work){
        this.buyer=buyer;
        this.value=value;
        this.auctionId=auctionId;
        this.work=work;

    }
    @Override
    public String getBuyerLogin() {
        return buyer.getLogin();
    }

    @Override
    public String getBuyerName() {
        return buyer.getName();
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getAuctionId() {
        return auctionId;
    }

    @Override
    public User getUser() {
        return buyer;
    }

    @Override
    public Work getWork() {
        return work;
    }

}
