import Exceptions.AlredyExistingUser;
import dataStructures.*;
import Exceptions.*;

public interface App {
    void addUser(String login, String name, int age, String email)throws AlredyExistingUser,InvalidAge;

    void addArtist(String login, String name, String artisticName, int age, String email)throws AlredyExistingUser,InvalidAge;

    void removeUser(String login)throws NonExistingUser;

    void addWork(String workId, String login, int year, String name)throws NonExistingUser,WrongUserType,ExistingWork;

    User getUser(String login);


    Work getWork(String workId);

    void createAuction(String auctionId);

    void addWorkAuction(String auctionId, String workId, int minValue);

    void bid(String auctionId, String workId, String login, int value);

    Iterator<Work> closeAuction(String auctionId);

    Iterator<Work> listAuctionWorks(String auctionId);

    Iterator<Bid> listBidsWork(String auctionId, String workId);
}
