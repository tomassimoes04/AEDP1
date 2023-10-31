package System;


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
        if(wasSold){
            return lastBuyer.getLogin();
        }
        return "nao foi vendido";

    }

    @Override
    public String getBuyerName() {
        if(wasSold){
            return lastBuyer.getName();
        }
        return "nao foi vendido";
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
    public void addBid(Bid bid) {
        bids.addLast(bid);
    }

    @Override
    public boolean hasBid(String auctionId) {
        for (int i = 0; i<bids.size(); i++){
            Bid bid = bids.get(i);
            if (bid.getAuctionId().equals(auctionId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setLastBuyValue(String auctionId) {
        lastBuyValue=getHighestBid(auctionId).getValue();
        if (lastBuyValue>highestBuyValue){
            highestBuyValue=lastBuyValue;
        }
    }

    @Override
    public void eraseBids(String auctionId) {
        int i = 0;
        //System.out.println("pre ciclo -work");
        //System.out.println(getName());
        //System.out.println(bids.size());
        while (bids.get(i)!=null){
            if (bids.get(i).getAuctionId().equals(auctionId)){
                bids.remove(i);
            }
            else{
                i++;
            }
            //System.out.println(bids.size()+" dentro ciclo "+ i);
            if (i==bids.size()){
                return;
            }
        }
    }

    @Override
    public Iterator<Bid> listBids(String auctionId) {
        DoubleList<Bid> auctionBids = new DoubleList<>();
        for (int i = 0; i<bids.size(); i++){
            Bid bid = bids.get(i);
            if (bid.getAuctionId().equals(auctionId)){
                auctionBids.addLast(bid);
            }
        }

        return auctionBids.iterator();
    }

    @Override
    public void setLastBuyer(User winner,int value) {
        lastBuyer=winner;
    }

    public Bid getHighestBid(String auctionId) {
        Queue<Bid> bidsAuction = auctionBids(auctionId);
        Bid highest = new BidClass(null, 0, null, null);
        if (!bidsAuction.isEmpty()) {
            highest = bidsAuction.dequeue();
        }
        while(!bidsAuction.isEmpty()){
            Bid bid = bidsAuction.dequeue();
            if (bid.getValue() > highest.getValue()){
                highest = bid;
            }
        }
        return highest;
    }

    private Queue<Bid> auctionBids(String auctionId){
        Queue<Bid> bidsAuction = new QueueInList<>();
        for (int i = 0; i<bids.size(); i++){
            Bid bid = bids.get(i);
            if (bid.getAuctionId().equals(auctionId)){
                bidsAuction.enqueue(bid);
            }
        }
        return bidsAuction;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof WorkClass)) {
            return false;
        }

        WorkClass w = (WorkClass) o;

        return workId.equals(w.getId());
    }


}
