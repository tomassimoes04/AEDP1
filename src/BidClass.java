public class BidClass implements Bid{

    private final User buyer;
    private final int value;
    private final String workId;

    public BidClass (User buyer, int value, String workId){
        this.buyer=buyer;
        this.value=value;
        this.workId = workId;

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
    public String getWorkId() {
        return workId;
    }

}
