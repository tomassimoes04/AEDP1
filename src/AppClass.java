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
        User ze = getUser(login);
        if (ze != null) {
            throw new AlredyExistingUser("\nUtilizador existente.\n");
        }
        if (age < 18) {
            throw new InvalidAge("\nIdade inferior a 18 anos.\n");
        }
        users.add(usercount, new UserClass(age, name, login, email));
        usercount++;
    }

    @Override
    public void addArtist(String login, String name, String artisticName, int age, String email) throws AlredyExistingUser, InvalidAge {
        User ze = getUser(login);
        if (ze != null) {
            throw new AlredyExistingUser("\nUtilizador existente.\n");
        }
        if (age < 18) {
            throw new InvalidAge("\nIdade inferior a 18 anos.\n");
        }
        users.add(usercount, new ArtistClass(age, name, login, email, artisticName));
        usercount++;

    }

    @Override
    public void removeUser(String login) throws NonExistingUser {
        if (getUser(login) == null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        users.remove(getUser(login));
        usercount--;
    }

    @Override
    public void addWork(String workId, String login, int year, String name) throws NonExistingUser, WrongUserType, ExistingWork {
        if (getUser(login) == null) {
            throw new NonExistingUser("\nUtilizador inexistente.\n");
        }
        if (!(getUser(login) instanceof ArtistClass)) {
            throw new WrongUserType("\nArtista inexistente.\n");
        }
        Artist ze = (Artist) getUser(login);

        if (ze.hasWork(workId)) {
            throw new ExistingWork("\nObra existente.\n");
        }
        ze.addWork(workId, ze, year, name);

        works.add(workscount, new WorkClass(workId, ze, year, name));
        //System.out.println("cheguei");
        //System.out.println(((ArtistClass) getUser(login)).getNumofworks()+"   "+((ArtistClass) getUser(login)).getFirstWork(workId));
        //System.out.println(getWork(workId).getId());
        workscount++;


    }

    @Override
    public User getUser(String login) {
        //System.out.println("cheguei");
        for (int i = 0; i < usercount; i++) {
            User user = users.get(i);
            //System.out.println(user.getLogin());
            if (user.getLogin().equals(login)) {
                //System.out.println("return user");
                return user;
            }
        }
        //System.out.println("d");
        return null;
    }


    @Override
    public Work getWork(String workId) {

        for (int i = 0; i < workscount; i++) {
            Work work1 = works.get(i);
            if (work1.getId().equals(workId)) {
                return work1;
            }
        }
        return null;
    }

    public Auction getAuction(String auctionId) {

        for (int i = 0; i < auctioncount; i++) {
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
        auctions.add(auctioncount, new AuctionClass(auctionId));
        auctioncount++;
    }

    @Override
    public void addWorkAuction(String auctionId, String workId, int minValue) throws NonExistingWork, NonExistingAuction {
        Auction auction = getAuction(auctionId);
        Work work = getWork(workId);
        if (auction == null) {
            throw new NonExistingAuction("erro");
        }
        if (work == null) {
            throw new NonExistingWork("erro");
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
            throw new NonExistingAuction("erro");
        }
        Work work = auction.getWork(workId);
        if (work == null) {
            throw new NonExistingWork("erro");
        }
        if (user == null) {
            throw new NonExistingUser("erro");
        }
        if (work.getMinimumValue() > value) {
            throw new InsuficientBid("erro");
        }
        auction.doBid(user, workId, value);
    }

    @Override
    public Iterator<Work> closeAuction(String auctionId) throws NonExistingAuction {
        Auction auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("erro");
        }
        Iterator<Work> iterator = auction.closeAuction();
        auctions.remove(auction);

        return iterator;
    }

    @Override
    public Iterator<Work> listAuctionWorks(String auctionId) throws NonExistingAuction, NoWorks{
        Auction auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("erro");
        }
        if (auction.isEmpty()) {
            throw new NoWorks("erro");
        }
        return auction.listWorks();
    }

    @Override
    public Iterator<Bid> listBidsWork(String auctionId, String workId) throws NonExistingAuction, NonExistingWork, NoBids{
        Auction auction = getAuction(auctionId);
        if (auction == null) {
            throw new NonExistingAuction("erro");
        }
        Work work = auction.getWork(workId);
        if (work == null) {
            throw new NonExistingWork("erro");
        }
        if (!work.hasBid()){
            throw new NoBids("erro");
        }
        return auction.listBidsWork(workId);
    }
}
