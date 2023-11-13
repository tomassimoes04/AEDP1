package System;
/**
 ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
 ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
 */


import dataStructures.*;

public class UserClass implements User {
    static final long serialVersionUID = 4L;

    private final int age;
    private final String name;
    private final String login;
    private final String email;
    private DoubleList<Bid> bids;



    public UserClass(int age, String name, String login, String email) {
        this.age = age;
        this.name = name;
        this.login = login;
        this.email = email;
        bids = new DoubleList<>();
    }


    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof UserClass)) {
            return false;
        }

        UserClass u = (UserClass) o;

        return login.equals(u.getLogin());
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

    protected void addBid(Bid bid) {
        bids.addLast(bid);
    }

    @Override
    public boolean hasBids() {
        return !bids.isEmpty();
    }

    /**
     * Erase the bids made from a user.
     * @param auctionId - The auction's ID
     */
    protected void eraseBids(String auctionId) {
        int i = 0;


        while (i < bids.size()) {
            if (bids.get(i).getAuctionId().equals(auctionId)) {
                bids.remove(i);
            } else {
                i++;
            }

        }
    }


}
