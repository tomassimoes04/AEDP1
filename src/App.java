import dataStructures.*;

public interface App {
    void addUser(String login, String name, int age, String email);

    void addArtist(String login, String name, String artisticName, int age, String email);

    void removeUser(String login);

    void addWork(String workId, String login, int year, String name);

    User getUser(String login);

    Artist getArtist(String login);

    Work getWork(String workId);

    void createAuction(String auctionId);

    void addWorkAuction(String auctionId, String workId, int minValue);

    void bid(String auctionId, String workId, String login, int value);

    Iterator<Work> closeAuction(String auctionId);

    Iterator<Work> listAuctionWorks(String auctionId);

    Iterator<Bid> listBidsWork(String auctionId, String workId);
}
