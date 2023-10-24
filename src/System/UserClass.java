package System;


import dataStructures.*;

public class UserClass implements User {
    private int age;
    private String name;
    private String login;
    private String email;
    private DoubleList<Bid> bids;



    public UserClass(int age, String name, String login, String email) {
        this.age = age;
        this.name = name;
        this.login = login;
        this.email = email;
        bids = new DoubleList<>();
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void addBid(Bid bid) {
        bids.addLast(bid);
        //System.out.println(bids.size());
    }

    @Override
    public boolean hasBids() {
        return !bids.isEmpty();
    }

    @Override
    public void eraseBids(String auctionId) {
        int i = 0;
        //System.out.println("pre ciclo -user");
        //System.out.println(getName());
        //System.out.println(bids.size());

        while (i < bids.size()) {
            if (bids.get(i).getAuctionId().equals(auctionId)) {
                bids.remove(i);
            } else {
                i++;
            }
            //System.out.println(bids.size()+" dentro ciclo "+ i);
        }
    }


}
