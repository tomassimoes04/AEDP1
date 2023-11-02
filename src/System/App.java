package System;

import Exceptions.AlredyExistingUser;
import dataStructures.*;
import Exceptions.*;

import java.io.Serializable;

public interface App extends Serializable {
    /**
     * Method to add a new user
     * @param login - The user's login
     * @param name - The user's name
     * @param age - The user's age
     * @param email - The user's email
     * @throws AlredyExistingUser - Thrown when a user with the same login already exists
     * @throws InvalidAge - Thrown when the provided age is under 18
     */
    void addUser(String login, String name, int age, String email) throws AlredyExistingUser, InvalidAge;

    /**
     * Method to add a new artist
     * @param login - The artist's login
     * @param name - The artist's name
     * @param artisticName - The artist's artistic name
     * @param age - The artist's age
     * @param email - The artist's email
     * @throws AlredyExistingUser - Thrown when an artist with the same login already exists
     * @throws InvalidAge - Thrown when the provided age is invalid
     */
    void addArtist(String login, String name, String artisticName, int age, String email) throws AlredyExistingUser, InvalidAge;

    /**
     * Method to remove a user
     * @param login - The login of the user to be removed
     * @throws NonExistingUser - Thrown when the user does not exist
     * @throws BidsInAuction - Thrown when the user has placed bids in an auction
     * @throws WorksInAuction - Thrown when the user has works in an auction
     */
    void removeUser(String login) throws NonExistingUser, BidsInAuction, WorksInAuction;

    /**
     * Method to add a work
     * @param workId - The work's ID
     * @param login - The artist's login
     * @param year - The year of the work
     * @param name - The name of the work
     * @throws NonExistingUser - Thrown when the artist does not exist
     * @throws WrongUserType - Thrown when the user is not an artist
     * @throws ExistingWork - Thrown when a work with the same ID already exists
     */
    void addWork(String workId, String login, int year, String name) throws NonExistingUser, WrongUserType, ExistingWork;

    /**
     *Method to retrieve a user
     * @param login - The artist's login
     * @return user
     */

    User getUser(String login);

    /**
     *Method to retrieve a work
     * @param workId
     * @return work
     */

    Work getWork(String workId);

    /**
     * Method to create an auction
     * @param auctionId - The ID of the auction to be created
     * @throws AlreadyExistingAuction - Thrown when an auction with the same ID already exists
     */

    void createAuction(String auctionId) throws AlreadyExistingAuction;

    /**
     * Method to add a work to an auction
     * @param auctionId - The ID of the auction
     * @param workId - The ID of the work to be added to the auction
     * @param minValue - The minimum value for the work in the auction
     * @throws NonExistingWork - Thrown when the work does not exist
     * @throws NonExistingAuction - Thrown when the auction does not exist
     */

    void addWorkAuction(String auctionId, String workId, int minValue) throws NonExistingWork, NonExistingAuction;

    /**
     * Method to place a bid on a work in an auction
     * @param auctionId - The ID of the auction
     * @param workId - The ID of the work
     * @param login - The user's login placing the bid
     * @param value - The bid value
     * @throws NonExistingWork - Thrown when the work does not exist
     * @throws NonExistingAuction - Thrown when the auction does not exist
     * @throws NonExistingUser - Thrown when the user does not exist
     * @throws InsuficientBid - Thrown when the bid value is insufficient
     */

    void bid(String auctionId, String workId, String login, int value) throws NonExistingWork, NonExistingAuction, NonExistingUser, InsuficientBid;

    /**
     * Method to close an auction and retrieve the winning bids
     * @param auctionId - The ID of the auction to be closed
     * @return Iterator of WorkClass representing the winning works
     * @throws NonExistingAuction - Thrown when the auction does not exist
     */

    Iterator<WorkClass> closeAuction(String auctionId) throws NonExistingAuction;

    /**
     * Method to list the works in an auction
     * @param auctionId - The ID of the auction
     * @return Iterator of WorkClass representing the works in the auction
     * @throws NonExistingAuction - Thrown when the auction does not exist
     * @throws NoWorks - Thrown when there are no works in the auction
     */

    Iterator<WorkClass> listAuctionWorks(String auctionId) throws NonExistingAuction, NoWorks;

    /**
     * Method to list the bids on a specific work in an auction
     * @param auctionId - The ID of the auction
     * @param workId - The ID of the work
     * @return Iterator of Bid representing the bids on the work
     * @throws NonExistingAuction - Thrown when the auction does not exist
     * @throws NonExistingWork - Thrown when the work does not exist
     * @throws NoBids - Thrown when there are no bids on the work
     */
    Iterator<Bid> listBidsWork(String auctionId, String workId) throws NonExistingAuction, NonExistingWork, NoBids;
}
