public class BidClass implements Bid{

    private User buyer;
    private int value;
    private String auctionId;

    public BidClass (User buyer, int value, String auctionId){
        this.buyer=buyer;
        this.value=value;
        this.auctionId=auctionId;

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

}
