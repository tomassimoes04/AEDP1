import Exceptions.AlredyExistingUser;
import dataStructures.*;
import Exceptions.*;

public interface App {
    void addUser(String login, String name, int age, String email) throws AlredyExistingUser, InvalidAge;

    void addArtist(String login, String name, String artisticName, int age, String email) throws AlredyExistingUser, InvalidAge;

    void removeUser(String login) throws NonExistingUser;

    void addWork(String workId, String login, int year, String name) throws NonExistingUser, WrongUserType, ExistingWork;

    User getUser(String login);

    Work getWork(String workId);

    void createAuction(String auctionId) throws AlreadyExistingAuction;

    void addWorkAuction(String auctionId, String workId, int minValue) throws NonExistingWork, NonExistingAuction;

    void bid(String auctionId, String workId, String login, int value) throws NonExistingWork, NonExistingAuction, NonExistingUser, InsuficientBid;

    Iterator<Work> closeAuction(String auctionId) throws NonExistingAuction;

    Iterator<Work> listAuctionWorks(String auctionId) throws NonExistingAuction, NoWorks;

    Iterator<Bid> listBidsWork(String auctionId, String workId) throws NonExistingAuction, NonExistingWork, NoBids;
}
