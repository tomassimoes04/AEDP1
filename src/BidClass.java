public class BidClass implements Bid{

    private final User buyer;
    private final int value;

    public BidClass (User buyer, int value){
        this.buyer=buyer;
        this.value=value;
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
}
