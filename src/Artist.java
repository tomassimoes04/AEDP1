import dataStructures.*;
public interface Artist extends User{

    String getArtisticName();
    Iterator<Work> getWorks();
    int getNumofworks();
    void addWork(String workId, String login, int year, String name);
    boolean hasWork(String workId);
}
