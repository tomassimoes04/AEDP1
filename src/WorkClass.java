import dataStructures.*;

public class WorkClass implements Work {
    String workId;
    Artist artist;
    int year;
    String name;
    int minValue;

    int lastBuyValue;

    int highestBuyValue;

    User lastBuyer;

    boolean wasSold;

    DoubleList<Bid> bids;

    public WorkClass(String workId, Artist artist, int year, String name) {
        this.workId = workId;
        this.artist = artist;
        this.year = year;
        this.name = name;
        minValue = 0;
        lastBuyValue = 0;
        highestBuyValue = 0;
        lastBuyer = null;
        wasSold = false;
        bids = new DoubleList<>();
    }


    @Override
    public String getId() {
        return workId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getLastBuyValue() {
        return lastBuyValue;
    }

    @Override
    public String getBuyerLogin() {
        return lastBuyer.getLogin();
    }

    @Override
    public String getBuyerName() {
        return lastBuyer.getName();
    }

    @Override
    public boolean wasSold() {
        return wasSold;
    }

    @Override
    public int highestBuyValue() {
        return highestBuyValue;
    }

    @Override
    public String getArtistLogin() {
        return artist.getLogin();
    }

    @Override
    public String getArtistName() {
        return artist.getName();
    } //ou artistic name

    @Override
    public void setMinimumValue(int value) {
        minValue = value;
    }

    @Override
    public int getMinimumValue() {
        return minValue;
    }

    @Override
    public void notSold() {
        wasSold = false;
    }

    @Override
    public void sold() {
        wasSold = true;
    }

    @Override
    public void addBid(User buyer, int value) {
        bids.addLast(new BidClass(buyer, value));
    }

    @Override
    public boolean hasBid() {
        return !bids.isEmpty();
    }

    @Override
    public void setLastBuyValue() {
        lastBuyValue=getHighestBid();
        if (lastBuyValue>highestBuyValue){
            highestBuyValue=lastBuyValue;
        }
    }

    @Override
    public void eraseBids() {
        while (!bids.isEmpty()){
            bids.removeFirst();
        }
    }

    @Override
    public Iterator<Bid> listBids() {
        return bids.iterator();
    }

    private int getHighestBid(){
        int highest = bids.get(0).getValue();
        for (int i=0; i<bids.size(); i++){
            if (bids.get(i).getValue()>highest){
                highest=bids.get(i).getValue();
            }
        }
        return highest;
    }

}
