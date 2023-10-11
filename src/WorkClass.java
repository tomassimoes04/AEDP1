public class WorkClass implements  Work{
    String workId;
    String login;
    int year;
    String name;

    int lastBuyValue;

    int highestBuyValue;

    boolean wasSold;

    User owner;

    Artist creator;

    public WorkClass(String workId, Artist creator, int year, String name) {
        this.workId = workId;
        this.creator = creator;
        this.year = year;
        this.name = name;
        lastBuyValue = 0;
        highestBuyValue = 0;
        wasSold = false;
        owner = null;
    }


    @Override
    public String getId() {
        return workId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getLastBuyValue() {
        return lastBuyValue;
    }

    @Override
    public String getBuyerLogin() {
        return owner.getLogin();
    }

    @Override
    public String getBuyerName() {
        return owner.getName();
    }

    @Override
    public boolean wasSold() {
        return wasSold;
    }

    @Override
    public int highestBuyValue() {
        return highestBuyValue;
    }

    @Override
    public String getArtistLogin() {
        return creator.getLogin();
    }

    @Override
    public String getArtistName() {
        return creator.getArtisticName();
    }
}
