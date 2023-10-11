import dataStructures.*;
import Exceptions.*;

public class AppClass implements App {
    DoubleList<User>users=new DoubleList<>();
    DoubleList<Work>works=new DoubleList<>();
    int usercount=0;
    int workscount=0;

    @Override
    public void addUser(String login, String name, int age, String email)throws AlredyExistingUser,InvalidAge {
        User ze =getUser(login);
        if(ze!=null){
            throw new AlredyExistingUser("Utilizador existente.");
        }
        if(age<18){
            throw new InvalidAge("Idade inferior a 18 anos.");
        }
        users.add(usercount, new UserClass(age,name,login,email));
        usercount++;
    }

    @Override
    public void addArtist(String login, String name, String artisticName, int age, String email) throws AlredyExistingUser,InvalidAge {
        User ze =getUser(login);
        if(ze!=null){
            throw new AlredyExistingUser("Utilizador existente.");
        }
        if(age<18){
            throw new InvalidAge("Idade inferior a 18 anos.");
        }
        users.add(usercount, new ArtistClass(age,name,login,email,artisticName));
        usercount++;

    }

    @Override
    public void removeUser(String login) throws NonExistingUser{
        if(getUser(login)==null){
            throw new NonExistingUser("Utilizador inexistente.");
        }
        users.remove(getUser(login));
        usercount--;
    }

    @Override
    public void addWork(String workId, String login, int year, String name)throws NonExistingUser,WrongUserType,ExistingWork {
        if(getUser(login)==null){
            throw new NonExistingUser("Utilizador inexistente.");
        }
        if(!(getUser(login) instanceof ArtistClass)){
            throw new WrongUserType("Artista inexistente.");
        }
        Artist ze= (Artist) getUser(login);
        if(!ze.hasWork(workId)){
            throw new ExistingWork("Obra existente.");
        }
        ze.addWork(workId, login, year, name);
        works.add(workscount,new WorkClass(workId, login, year, name));
        workscount++;


    }

    @Override
    public User getUser(String login) {
        for (int i = 0; i < usercount; i++) {
            User user = users.get(i);
            if (user.getName().equals(login)) {
                return user;
            }
        }
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
