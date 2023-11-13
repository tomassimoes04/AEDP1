package System;
/**
 ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
 ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
 */


public class BidClass implements Bid{
    static final long serialVersionUID = 3L;


    private final User buyer;
    private final int value;
    private final String auctionId;

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

    @Override
    public User getUser() {
        return buyer;
    }



}
