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
    }

    @Override
    public boolean hasBids() {
        return !bids.isEmpty();
    }

    @Override
    public void eraseBids(String auctionId) {
        int i = 0;
        while (bids.get(i)!=null){
            if (bids.get(i).getAuctionId().equals(auctionId)){
                bids.remove(i);
            }
            else{
                i++;
            }
        }
    }
}
