package System;


import dataStructures.*;
import Exceptions.*;
/**
 ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
 ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
 */
public class AppClass implements App {
    SearchableList<UserClass> users ;
    SearchableList<WorkClass> works ;
    SearchableList<AuctionClass> auctions ;
    static final long serialVersionUID = 0L;
    public AppClass(){
        users = new SearchableDoubleList<>();
        works = new SearchableDoubleList<>();
        auctions = new SearchableDoubleList<>();
    }


    @Override
    public void addUser(String login, String name, int age, String email) throws AlredyExistingUser, InvalidAge {
        if (age < 18) {
            throw new InvalidAge("\nIdade inferior a 18 anos.\n");
        }
        UserClass user = getUser(login);
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
        UserClass user = getUser(login);
        if (user != null) {
            throw new AlredyExistingUser("\nUtilizador existente.\n");
        }
        users.addLast(new ArtistClass(age, name, login, email, artisticName));
    }

    @Override
    public void removeUser(String login) throws NonExistingUser, BidsInAuction, WorksInAuction{
        UserClass user = getUser(login);
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

    /**
     * Returns if a artist as any work in an auction
     * @param login - The artist's login.
     * @return true or false
     */
    private boolean hasActiveWorks(String login){
        for (int i = 0; i<auctions.size(); i++){
            Auction auction = auctions.get(i);
            if (auction.hasWorksInAuction(login)){
                return true;
            }
        }
        return false;
    }

    /**
     * Remove the works from an artist whhich was removed
     * @param login - The artist's login.
     */

    private void removeWorksArtist(String login){
        Queue<WorkClass> worksToRemove = new QueueInList<>();
        for (int i = 0; i<works.size(); i++){
            WorkClass work = works.get(i);
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

        UserClass user = getUser(login);
        if (user == null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        if (!(user instanceof ArtistClass)) {
            throw new WrongUserType("\nArtista inexistente.\n");
        }
        ArtistClass artist = (ArtistClass) user;

        WorkClass work = new WorkClass(workId, artist, year, name);
        artist.addWork(work);

        works.addLast(work);
    }

    @Override
    public UserClass getUser(String login) {
        UserClass user = new UserClass(0, null, login, null);
        return users.searchElement(user);

    }


    @Override
    public WorkClass getWork(String workId) {
        WorkClass work = new WorkClass(workId, null, 0, null);
        return works.searchElement(work);

    }

    public AuctionClass getAuction(String auctionId) {
        AuctionClass auction = new AuctionClass(auctionId);
        return auctions.searchElement(auction);
    }

    @Override
    public void createAuction(String auctionId) throws AlreadyExistingAuction {
        AuctionClass auction = getAuction(auctionId);
        if (auction != null) {
            throw new AlreadyExistingAuction("\nLeilao existente.\n");
        }
        auctions.addLast(new AuctionClass(auctionId));
    }

    @Override
    public void addWorkAuction(String auctionId, String workId, int minValue) throws NonExistingWork, NonExistingAuction {
        AuctionClass auction = getAuction(auctionId);
        WorkClass work = getWork(workId);
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
        UserClass user = getUser(login);
        if (user == null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        AuctionClass auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        WorkClass work = auction.getWork(workId);
        if (work == null) {
            throw new NonExistingWork("\nObra inexistente no leilao.\n");
        }
        if (work.getMinimumValue() > value) {
            throw new InsuficientBid("\nValor proposto abaixo do valor minimo.\n");
        }
        auction.doBid(user, work, value);
    }

    @Override
    public Iterator<WorkClass> closeAuction(String auctionId) throws NonExistingAuction {
        AuctionClass auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        Iterator<WorkClass> iterator = auction.closeAuction();
        auctions.remove(auction);

        return iterator;
    }

    @Override
    public Iterator<WorkClass> listAuctionWorks(String auctionId) throws NonExistingAuction, NoWorks {
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
        AuctionClass auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("\nLeilao inexistente.\n");
        }
        if (!auction.hasWork(workId)) {
            throw new NonExistingWork("\nObra inexistente no leilao.\n");
        }
        WorkClass work = auction.getWork(workId);
        if (!work.hasBid(auctionId)) {
            throw new NoBids("\nObra sem propostas.\n");
        }
        return auction.listBidsWork(workId);
    }
}
