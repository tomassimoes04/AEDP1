public interface Bid {
    String getBuyerLogin();
    String getBuyerName();
    int getValue();
    String getAuctionId();
    User getUser();
    Work getWork();
}
