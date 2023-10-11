public class WorkClass implements  Work{
    String workId;
    String login;
    int year;
    String name;

    public WorkClass(String workId, String login, int year, String name) {
        this.workId = workId;
        this.login = login;
        this.year = year;
        this.name = name;
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
        return 0;
    }

    @Override
    public String getBuyerLogin() {
        return null;
    }

    @Override
    public String getBuyerName() {
        return null;
    }

    @Override
    public boolean wasSold() {
        return false;
    }

    @Override
    public int highestBuyValue() {
        return 0;
    }

    @Override
    public String getArtistLogin() {
        return null;
    }

    @Override
    public String getArtistName() {
        return null;
    }
}
