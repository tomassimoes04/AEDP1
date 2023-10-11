import dataStructures.Iterator;

public class AppClass implements App {
    @Override
    public void addUser(String login, String name, int age, String email) {

    }

    @Override
    public void addArtist(String login, String name, String artisticName, int age, String email) {

    }

    @Override
    public void removeUser(String login) {

    }

    @Override
    public void addWork(String workId, String login, int year, String name) {

    }

    @Override
    public User getUser(String login) {
        return null;
    }

    @Override
    public Artist getArtist(String login) {
        return null;
    }

    @Override
    public Work getWork(String workId) {
        return null;
    }

    @Override
    public void createAuction(String auctionId) {

    }

    @Override
    public void addWorkAuction(String auctionId, String workId, int minValue) {

    }

    @Override
    public void bid(String auctionId, String workId, String login, int value) {

    }

    @Override
    public Iterator<Work> closeAuction(String auctionId) {
        return null;
    }

    @Override
    public Iterator<Work> listAuctionWorks(String auctionId) {
        return null;
    }

    @Override
    public Iterator<Bid> listBidsWork(String auctionId, String workId) {
        return null;
    }
}
