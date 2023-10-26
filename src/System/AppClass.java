package System;


import dataStructures.*;
import Exceptions.*;

public class AppClass implements App {
    DoubleList<User> users = new DoubleList<>();

    DoubleList<Work> works = new DoubleList<>();
    DoubleList<Auction> auctions = new DoubleList<>();
    int usercount = 0;
    int workscount = 0;
    int auctioncount = 0;

    @Override
    public void addUser(String login, String name, int age, String email) throws AlredyExistingUser, InvalidAge {
        if (age < 18) {
            throw new InvalidAge("\nIdade inferior a 18 anos.\n");
        }
        User user = getUser(login);
        if (user != null) {
            throw new AlredyExistingUser("\nUtilizador existente.\n");
        }
        users.addLast(new UserClass(age, name, login, email));
    }

    @Override
    public void addArtist(String login, String name, String artisticName, int age, String email) throws AlredyExistingUser, InvalidAge {
        if (age < 18) {
            throw new InvalidAge("\nIdade inferior a 18 anos.\n");
        }
        User user = getUser(login);
        if (user != null) {
            throw new AlredyExistingUser("\nUtilizador existente.\n");
        }
        users.addLast(new ArtistClass(age, name, login, email, artisticName));
    }

    @Override
    public void removeUser(String login) throws NonExistingUser, BidsInAuction, WorksInAuction{
        User user = getUser(login);
        if (user== null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        if (user.hasBids()) {
            throw new BidsInAuction("\nUtilizador com propostas submetidas.\n");
        }
        if (user instanceof Artist){
            if (hasActiveWorks(login)) {
                throw new WorksInAuction("\nArtista com obras em leilao.\n");
            }
            removeWorksArtist(login);
        }
        users.remove(user);
    }

    private boolean hasActiveWorks(String login){
        for (int i = 0; i<auctions.size(); i++){
            Auction auction = auctions.get(i);
            if (auction.hasWorksInAuction(login)){
                return true;
            }
        }
        return false;
    }

    private void removeWorksArtist(String login){
        Queue<Work> worksToRemove = new QueueInList<>();
        for (int i = 0; i<works.size(); i++){
            Work work = works.get(i);
            if (work.getArtistLogin().equals(login)){
                worksToRemove.enqueue(work);
            }
        }
        while (!worksToRemove.isEmpty()){
            works.remove(worksToRemove.dequeue());
        }
    }

    @Override
    public void addWork(String workId, String login, int year, String name) throws NonExistingUser, WrongUserType, ExistingWork {
        if (getWork(workId)!=null) {
            throw new ExistingWork("\nObra existente.\n");
        }

        User user = getUser(login);
        if (user == null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        if (!(user instanceof ArtistClass)) {
            throw new WrongUserType("\nArtista inexistente.\n");
        }
        Artist artist = (Artist) user;

        Work work = new WorkClass(workId, artist, year, name);
        artist.addWork(work);

        works.addLast(work);
    }

    @Override
    public User getUser(String login) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }


    @Override
    public Work getWork(String workId) {

        for (int i = 0; i < works.size(); i++) {
            Work work1 = works.get(i);
            if (work1.getId().equals(workId)) {
                return work1;
            }
        }
        return null;
    }

    public Auction getAuction(String auctionId) {

        for (int i = 0; i < auctions.size(); i++) {
            Auction auction = auctions.get(i);
            if (auction.getId().equals(auctionId)) {
                return auction;
            }
        }
        return null;
    }

    @Override
    public void createAuction(String auctionId) throws AlreadyExistingAuction {
        Auction auction = getAuction(auctionId);
        if (auction != null) {
            throw new AlreadyExistingAuction("\nLeilao existente.\n");
        }
        auctions.addLast(new AuctionClass(auctionId));
    }

    @Override
    public void addWorkAuction(String auctionId, String workId, int minValue) throws NonExistingWork, NonExistingAuction {
        Auction auction = getAuction(auctionId);
        Work work = getWork(workId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        if (work == null) {
            throw new NonExistingWork("\nObra inexistente.\n");
        }
        work.setMinimumValue(minValue);
        auction.addWork(work);
        work.notSold();
    }

    @Override
    public void bid(String auctionId, String workId, String login, int value) throws NonExistingWork, NonExistingAuction, NonExistingUser, InsuficientBid {
        Auction auction = getAuction(auctionId);
        User user = getUser(login);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        Work work = auction.getWork(workId);
        if (work == null) {
            throw new NonExistingWork("\nObra inexistente no leilao.\n");
        }
        if (user == null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        if (work.getMinimumValue() > value) {
            throw new InsuficientBid("\nValor proposto abaixo do valor minimo.\n");
        }
        auction.doBid(user, work, value);
    }

    @Override
    public Iterator<Work> closeAuction(String auctionId) throws NonExistingAuction {
        Auction auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        Iterator<Work> iterator = auction.closeAuction();
        auctions.remove(auction);

        return iterator;
    }

    @Override
    public Iterator<Work> listAuctionWorks(String auctionId) throws NonExistingAuction, NoWorks {
        Auction auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        if (auction.isEmpty()) {
            throw new NoWorks("\nLeilao sem obras.\n");
        }
        return auction.listWorks();
    }

    @Override
    public Iterator<Bid> listBidsWork(String auctionId, String workId) throws NonExistingAuction, NonExistingWork, NoBids {
        Auction auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        if (!auction.hasWork(workId)) {
            throw new NonExistingWork("\nObra inexistente no leilao.\n");
        }
        Work work = auction.getWork(workId);
        if (!work.hasBid()) {
            throw new NoBids("\nObra sem propostas.\n");
        }
        return auction.listBidsWork(workId);
    }
}
